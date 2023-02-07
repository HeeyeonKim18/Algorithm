package javaBook.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex14_7 {
    public static void main(String[] args) {
        String[] helloArr = {
                "Hi my name is Kim",
                "nice to meet you today",
                "welcome to this city"
        };

        Stream<String> stream = Arrays.stream(helloArr);
        stream.flatMap(hello -> Stream.of(hello.split(" +")))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
