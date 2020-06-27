package com.example.demo.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/4/22 11:58
 */
public class ABADemo {
    private static volatile Integer a = 100;
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(a ,1);
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        AtomicInteger atomicInteger = new AtomicInteger(5);
//        atomicInteger.compareAndSet(5,10);
        // 获取字段
//        Field filed = Unsafe.class.getDeclaredField("theUnsafe");
//        // 设置可访问
//        filed.setAccessible(true);
//        // 获取Unsafe实例
//        Unsafe unsafe = (Unsafe)filed.get(null);
//        Field field = ABADemo.class.getDeclaredField("a");
//        long offset = unsafe.objectFieldOffset(field);

//        boolean andSwapInt = unsafe.compareAndSwapInt(a, offset,100,101);
//        System.out.println(andSwapInt);
//        System.out.println(a);
        new Thread(() -> {
            System.out.println("t1拿到的初始版本号:" + atomicStampedReference.getStamp());

            //睡眠1秒，是为了让t2线程也拿到同样的初始版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            atomicStampedReference.compareAndSet(101, 100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
        },"t1").start();

        //下面注释打开的话就会让t2 修改成功
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("t2拿到的初始版本号:" + stamp);

            //睡眠3秒，是为了让t1线程完成ABA操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("最新版本号:" + atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet(
                    100, 2019,stamp,
                    atomicStampedReference.getStamp() + 1)


                    + "\t当前 值:" + atomicStampedReference.getReference());
        },"t2").start();
    }
}
class Test{
    // 需要CAS修改的字段
    private int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 获取字段
        Field filed = Unsafe.class.getDeclaredField("theUnsafe");

        // 设置可访问
        filed.setAccessible(true);
        // 获取Unsafe实例
        Unsafe unsafe = (Unsafe)filed.get(null);
        // 获取字段 i 的偏移量
        Test test = new Test();
        Field field = test.getClass().getDeclaredField("i");
        long offset = unsafe.objectFieldOffset(field);

        // CAS修改，返回布尔值
        boolean isSuccess = unsafe.compareAndSwapInt(test,offset,0,1);

        // 打印
        System.out.println(isSuccess);
        System.out.println(test.getI());
    }
}
