package com.asd.stream;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
* java 8 API 添加了一个新的抽象称为流Stream, 可以让你以一种声明的方式处理数据
* 这种风格将要处理的元素集合看作式一种流，流在管道中传输（intermediate operation），
* 最后由最终操作（termical operation）得到前面处理的结果。
*
* 什么式stream:
* 来自数据源的元素队列，并支持聚合操作
*
* 特点
* pipelining:中间操作都会返回流对象本身，这样多个操作可以串联成一个管道，如同流式风格fluent style.
* 这样做可以对操作进行优化，比如延迟执行和短路
* 内部迭代： 以前对集合遍历都是通过iterator或者for-each的方式，显示的在集合外部进行迭代，这个叫做外部迭代
* Stream提供了内部迭代的方式，通过访问者模式实现。
*
* */
public class Java8TesterStream {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("filtered : " +filtered);
        //forEach
        //limit  用于获取指定数量的流
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        //map 用于映射每个元素到对应的结果，
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        //获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i-> i*i).distinct().collect(Collectors.toList());
        System.out.println("squares : "+ squaresList);
        //filter
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","","jkl");
        long count = strings2.stream().filter(string -> string.isEmpty()).count();
        System.out.println("count : " + count);

        //sorted 对流进行排序
        random.ints().limit(10).sorted().forEach(System.out::println);

        //parallel 是流并行处理程序的替代方法，一下实例是我们使用parallelStream来输出空字符串的数量
        strings2 = Arrays.asList("abc", "","bc","efg","abcd","","jkl");
        count = strings2.parallelStream().filter(string->string.isEmpty()).count();
        System.out.println("empty string count : " + count);

        //Collectors类实现了很多归约操作，例如流转换成集合和聚合元素，Collectors可以用于返回列表或者字符串
        String joinString = strings2.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println(joinString);

        //统计
        List<Integer> numbers2 = Arrays.asList(3,2,2,3,7,3,5);
        IntSummaryStatistics statistics = numbers2.stream().mapToInt(x->x).summaryStatistics();
        System.out.println("列表中最大的数： "+ statistics.getMax());
        System.out.println("列表中最小的数： "+ statistics.getMin());
        System.out.println("所有数的和："+statistics.getSum());
        System.out.println("平均数："+statistics.getAverage());


    }
}
