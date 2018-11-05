package com.asd.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Java8TesterNewDateTimeAPI {
    /*
    *  java8 发布新的Date-Time API (JSR 310)来进一步加强对日期和时间的处理。
    *
    *  旧版的java中，日期和时间的api有诸多问题
    *  非线程安全－ java.util.Date是非线程安全的，所有的日期类都是可变的。也是java日期类的最大的问题之一
    *  设计很差－  java的日期和时间类的定义并不一致，在java.util和java.sql包中都有日期类，此外用于格式化和解析的类都在java.text
    *             包中定义。java.util.Date同时包含日期和时间，而java.sql.Date仅仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有
    *             相同的名字，这本身就是一个非常糟糕的设计。
    *  时区处理麻烦－ 日期类并不提供国际化，没有时区支持，因此java引入了java.util.Calendar 和java.util.TimeZone类， 但是他们同样存在上述
    *               所有问题。
    *
    *
    *  java8 在java.time包下提供了很多新的api, 以下为两个比较重要的API:
    *  Local(本地) － 简化了日期时间的处理，没有时区的问题。
    *  Zoned(时区) － 通过制定的时区处理日期时间
    *  新的java.time包含了所有的处理日期，时间，日期／时间，时区，时刻instants，过程during，时钟clock的操作
    *
    * */

    //LocalDate/LocalTime和LocalDateTime类可以在处理时区不是必须的情况

    public static void main(String[] args) {
        Java8TesterNewDateTimeAPI java8TesterNewDateTimeAPI= new Java8TesterNewDateTimeAPI();
        java8TesterNewDateTimeAPI.testLocalDateTime();
    }

    public void testLocalDateTime(){
        //获取当前的日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间：" + localDateTime);

        LocalDate date = localDateTime.toLocalDate();
        System.out.println("日期："+ date);

        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        int seconds = localDateTime.getSecond();

        System.out.println("月：" + month + ", 日：" + day + ", 秒：" + seconds);

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10).withYear(2012);
        System.out.println("第二个当前时间：" + localDateTime1);

        LocalDate date1 =LocalDate.of(2018,Month.NOVEMBER, 6);
        System.out.println("第二个日期：" + date1);

        LocalTime time = LocalTime.of(8,57);
        System.out.println("第二个时间：" + time);

        LocalTime time2 = LocalTime.parse("08:58:22");
        System.out.println("第三个时间：" + time2);

    }
}
