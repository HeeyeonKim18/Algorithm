package javaBook.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_9 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "Stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr).parallel().forEachOrdered(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length()==3);
        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0)=='s').findFirst();

        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord = " + sWord);

        IntStream intStream = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2= Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream.reduce(0, (a,b) -> a+1);
        int sum = intStream1.reduce(0, (a,b) -> a+b);

        OptionalInt max = intStream2.reduce(Integer::max);
        OptionalInt min = intStream3.reduce(Integer::min);

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max = " + max.getAsInt());
        System.out.println("min = " + min);


    }
}
