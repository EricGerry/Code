package com.Java8;

import java.lang.ref.SoftReference;

public class lambdaDemo {
    public static void main(String[] args) {
        lambdaDemo lambdaDemo = new lambdaDemo();
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (int a, int b) ->{return a * b;};
        MathOperation division = (a, b)->a / b;
        System.out.println("10 + 5 = " + lambdaDemo.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambdaDemo.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambdaDemo.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambdaDemo.operate(10, 5, division));

        GreetingService service = message -> System.out.println("Hello" + message);

        service.sayMessage("world");
    }
    interface MathOperation{
        int operation(int a, int b);
    }
    interface GreetingService {
        void sayMessage(String message);
    }
    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
