package com.unit3;

public class MethodReferenceExample1 {
    public static void main(String [] args) {
        // printMessage(); // 1. directly calling the function
        // Thread t = new Thread( () -> printMessage() ); // 2. using a new thread but with lambda
        // as printMessage is static, ClassName::method
        Thread t = new Thread(MethodReferenceExample1::printMessage); // 3. using method reference
        t.start();
    }
    public static void printMessage() {
        System.out.println("Hello");
    }
}
