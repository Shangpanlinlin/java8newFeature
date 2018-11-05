package com.asd.lambda;

import java.awt.*;

/*
*  lambda表达式也可以称为闭包，它是推动java8发布的最重要的特性
*  lambda允许把函数作为一个方法的参数
*  使用lambda可以使得代码更加的紧凑和简洁
*
*  lambda表达式的重要特征
*  1.可选的类型声明： 不需要声明参数的类型，编译器可以统一识别参数的值
*  2.可选的参数圆括号：一个参数无需定义圆括号，但是多个参数可以定义园括号
*  2.可选的大括号：如果主体包含了一个语句，就不需要大括号
*  4.可选的返回关键字：如果主体知识有一个表达式返回值，编译器会自动返回，
*
*  lambda 表达式实现的接口的操作，改接口必须式函数式接口，也就是只有一个接口方法， 如果超过两个，编译会报错。
* */
public class Java8TesterForLambda {
    public static void main(String[] args) {
        Java8TesterForLambda tester = new Java8TesterForLambda();
        MathOperation addition = (int a, int b) -> a+b;
        MathOperation subtraction = (a,b) -> a-b;
        MathOperation multiplication = (int a, int b) -> {return a*b;};
        MathOperation division = (int a, int b ) -> a/b;

        System.out.println("10+5=" + tester.operate(10,5,addition));
        System.out.println("10-5=" + tester.operate(10,5,subtraction));
        System.out.println("10*5=" + tester.operate(10,5,multiplication));
        System.out.println("10/5=" + tester.operate(10,5,division));

        GreetingService greetingService = message -> System.out.println("Hello " + message);
        greetingService.sayMessage("guangshu");

        //有default的函数式接口的case
        //MathOperation2 addition = (a, b) -> a + b + b;
        // 会有编译错误，会说addition已经在scope里面有定义了
        MathOperation2 addition2 = (a, b) -> a + b + b;
        System.out.println("MathOperation2 10 + 5 = " + addition.operation(10,5) );
        System.out.println("MathOperation2 10 + 5 ＋ 5 = " + addition2.operation(10,5) );

    }

    interface  MathOperation{
        int operation(int a, int b);
    }

    //lambda要求接口必须式函数式接口，但是可以允许有default的逻辑实现的方法
    //这里面有一个addition的默认实现，这个addition相当于MathOperaion2的匿名实现类。
    interface MathOperation2{
        int operation(int a, int b);
        default int addition(int a, int b){
            return a + b;
        }
    }

    interface  GreetingService{
        void sayMessage(String message);
    }
    //Java8TesterForLambda类里面的私有成员函数，类的静态成员函数可以见到，可以调用。就是类自己的成员不管是静态还是非静态都可见
    private int operate(int a , int b, MathOperation operation){
        return operation.operation(a,b);
    }
}
