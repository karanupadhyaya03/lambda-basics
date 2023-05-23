package com.unit2;
/*
In an anonymous inner class when using 'this' reference, you have overwritten 'this' reference
i.e. the anonymous inner class instance overrides with 'this' reference
i.e. the value changes inside the anonymous inner class

In case of a lambda it still refers to the instance that it points to outside of the lambda
*/


public class ThisReferenceExample {
    public void doProcess(int i, Process p) {
        p.process(i);
    }
    // CODE 3
    public void execute() {
        // this === ThisReferenceExample
        doProcess(10, i -> {
            System.out.println(i);
            System.out.println(this);
        });
    }
    public static void main(String [] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        /* CODE 1
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process (int i) {
                System.out.println(i);
                System.out.println(this);
            }
            public String toString() {
                return "This is the anonymous inner class";
            }
        });*/

        /* CODE 2
        thisReferenceExample.doProcess(10, i -> {
            System.out.println(i);
            // System.out.println(this); // it can not be performed
            // as 'this' in method where it is called('main' === static) is not defined
        });*/

        // CODE 3
        thisReferenceExample.execute();
    }
    // CODE 3
    public String toString() {
        return "This is the main ThisReferenceExample class instance";
    }
}
