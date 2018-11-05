package com.asd.lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Java8TesterMethodHandler {
    /*
     *  方法引用通过方法的一个名字来指向一个方法
     *  方法应用可以使得语言的构造紧凑简洁，
     *  减少冗余代码
     *  方法引用使用：：
     *  下面我们在Car类中定义了4个方法作为例子来区分java中4中不同的方法引用
     *  1. 构造器引用 Class::new Class<T>::new
     *  final Car car = Car.create(Car::new);
     *  final List<Car> cars = Arrays.asList(car);
     *  2. 静态方法引用 Class::static_method,实例如下
     *  cars.forEach(Car::collide);
     *  3.特定类的任意对象的方法引用
     *  cars.forEach(Car::repair);
     *  4.特定对象的方法引用：
     *  final Car police = Car.create(Car::new)
     *  cars.forEach(police::follow)
     *
     * */

    public static void main(String[] args) {
        List names = new ArrayList<String>();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }

}
class Car{

    public  static  Car create(final Supplier<Car> supplier){
        return supplier.get();
    }

    public  static  void collide(final Car another){
        System.out.println("Collide " + another.toString());
    }

    public void follow(final Car car){
        System.out.println("Following the " + car.toString());

    }

    public void repair(){
        System.out.println("Repaired " + this.toString());
    }
}