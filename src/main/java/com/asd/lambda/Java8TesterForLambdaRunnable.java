package com.asd.lambda;

public class Java8TesterForLambdaRunnable {
    public static void main(String[] args) {
        new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("Hello World !");
            }
        }).start();


        new Thread(() -> System.out.println("Hello world !")).start();

        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable hello world");
            }
        };
        Runnable race2 = () -> System.out.println("runnable hello world2");

        //直接调用run方法 没有开新线程
        race1.run();
        race2.run();
    }

}
