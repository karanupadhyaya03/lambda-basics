package com.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandling {
    public static void main(String [] args) {
        int [] someNumbers = { 1, 2, 3, 4 };
//        process(someNumbers, 0, (v, k) -> {
//            try{
//                System.out.println(v / k);
//            } catch(ArithmeticException e) {
//                System.out.println("An Arithmetic Exception Happened");
//            }
//        });
        process(someNumbers, 0, wrapperLambda((v, k)->System.out.println(v/k)));
    }

    public static void process(int [] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for(int i: someNumbers) {
            consumer.accept(i, key);
        }
    }

    public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException e) {
                System.out.println("An Arithmetic Exception Happened");
            }
        };
    }
}
