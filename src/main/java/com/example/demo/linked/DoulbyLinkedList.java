package com.example.demo.linked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/4/27 9:27
 */
public class DoulbyLinkedList {
    public static void main(String[] args) throws InterruptedException {
        int[] ints = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println();
        List<Integer> integers = Arrays.stream(ints).boxed().collect(Collectors.toList());
        LinkedList<Integer> list = new LinkedList<>(integers);
        for (int i = 0; i < list.size(); i++) {

        }
        int count =0;
        int i = ++count;

        try {
            List<String> list2 = new ArrayList<>();
            int item = 0;
            while(true){
                Thread.sleep(50);
                list2.add(String.valueOf(item++).intern());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        //弱引用
//        while (true){
//            Thread.sleep(1000);
//
////            WeakReference<String> weakReference = new WeakReference<String>(new String("Misout的博客"));
////            Thread.sleep(1000);
////            System.gc();
////            System.out.println("第一次gc"+ i);
////            if(weakReference.get() == null) {
////                System.out.println("weakReference已经被GC回收"+ i);
////            }
//        }
//        System.out.println(list.indexOf(i));
//        System.out.println(list);
    }
}
