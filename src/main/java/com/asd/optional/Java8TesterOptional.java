package com.asd.optional;

import java.util.Optional;

public class Java8TesterOptional {
    /*
    * Optional类是一个可以为null的容器对象，
    * 解决空指针异常（因为Optional做了所有的空值检测的工作）
    *
    * */

    public static void main(String[] args) {
        Java8TesterOptional tester = new Java8TesterOptional();

        Optional<Integer> a = Optional.ofNullable(null);
        Optional<Integer> b = Optional.of(10);
        System.out.println(tester.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        System.out.println("the first value : " + a.isPresent());
        System.out.println("the second value : " + b.isPresent());

        Integer value1 = a.orElse(0);
        Integer value2 = b.orElse(0);
        return value1 + value2;
    }
}

