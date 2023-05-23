package com.unit2;

public class ClosureExample {
    public static void main(String [] args) {
        int a = 10;
        int b = 20;

        // doProcess(a, new Process() {
        //     @Override
        //     public void process(int i) {
        //         System.out.println(i+b);
        //     }
        // });
        // the value of 'b' which is frozen is passed around
        // process will contain frozen value of 'b'
        doProcess(a, i -> System.out.println(i+b));
    }
    public static void doProcess(int i, Process p) {
        p.process(i);
    }
}
interface Process{
    void process(int i);
}