package javaBook.stream;

import java.util.stream.IntStream;

public class Ex14_0 {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(4, 2, 1, 5, 3);
//        Stream<Integer> intStream = list.stream();
//        intStream.forEach(System.out::print);
//        System.out.println();
////        intStream.forEach(System.out::println); // 에러 발생, 스트림은 최종 연산이 실행하고 나면 다시 사용 불가
//
//        Stream<String> stream = Stream.of("a", "b", "c"); // 가변인자
//        stream.forEach(System.out::print);
//
//        System.out.println();
//        IntStream intStream1 = IntStream.of(new int[]{1, 2, 3, 4, 5});
//        System.out.println("intStream1.count() = " + intStream1.count());
//
//        IntStream intStream2 = Arrays.stream(new int[]{5, 1, 7, 3, 8});
//        intStream2.forEach(System.out::print);
//
//        System.out.println();
//
//        IntStream intStream3 = new Random().ints();
//        intStream3.limit(5).forEach(System.out::println);
//
//        LongStream longStream = new Random().longs(5);
//        longStream.forEach(System.out::println);

        IntStream intStream1 = IntStream.range(1, 5);   // 1,2,3,4
        IntStream intStream2 = IntStream.range(1, 5);   // 1,2,3,4,5

    }
}
