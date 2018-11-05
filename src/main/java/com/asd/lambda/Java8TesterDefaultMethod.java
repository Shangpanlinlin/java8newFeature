package com.asd.lambda;

public class Java8TesterDefaultMethod {
    /**
     *  java8 新增了接口的默认方法
     *  简单说 默认方法 就是接口可以有实现方法，而且不需要实现类去实现其方法
     *  我们只需要在方法名前面加个default关键子即可实现默认方法
     *
     * 首先，之前的接口是个双刃剑，好处式面向抽象，而不是面向具体过程，坏处就是当修改接口的时候，需要修改全部实现该接口的类
     *
     * */
    public static void main(String[] args) {
        Car2 cars = new Car2();
        cars.print();;

        Car3 car3 = new Car3();
        System.out.println("--------------------");
        car3.print();
    }
}

interface Vehicle{
    default void print(){
        System.out.println("I am a car");
    }
}
interface FourWheeler{
    default void print(){
        System.out.println("I am four wheels ");
    }
}
/*
* 多个默认方法
* */
 class Car2 implements Vehicle, FourWheeler{
   /* public void print(){
        System.out.println("i am four wheels car ");
    }*/
   public void print(){
       Vehicle.super.print();
   }
}

/*
静态默认方法
*  java 8 的另一个特性式接口可以声明（并且可以提供实现）静态方法，
* */
 interface  SupVehicle{
    default void print(){
        System.out.println("i am supper car");
    }
    static void blowHorn(){
        System.out.println("di di di ! ~~~");
    }
}


/*
默认方法的实例
* */
class Car3 implements SupVehicle, FourWheeler{
    public void print(){
        SupVehicle.super.print();
        FourWheeler.super.print();
        SupVehicle.blowHorn();
        System.out.println("i am car 3");
    }
}