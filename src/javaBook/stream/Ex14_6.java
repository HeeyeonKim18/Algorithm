package javaBook.stream;

import java.io.File;
import java.util.stream.Stream;

public class Ex14_6 {
    public static void main(String[] args) {
        Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"),
                new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt"));

        // map()으로 Stream<File>을 Stream<String>으로 변환
        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1)
                .peek(s->System.out.printf("filename = %s%n", s))
                .map(s -> s.substring(s.indexOf('.') + 1))
                .peek(s->System.out.printf("extension = %s%n", s))
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }
}
