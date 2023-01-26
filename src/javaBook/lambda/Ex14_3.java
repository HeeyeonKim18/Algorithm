package javaBook.lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class Ex14_3 {
    public static void main(String[] args) {
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16); // 문자를 16진수로 변환
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i); // 2진수로 변환

        Function<String, String> h = f.andThen(g);    // f -> g
        Function<Integer, Integer> h2 = f.compose(g); // andThen를 거꾸로, g -> f

        System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2));   // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x; // 항등 함수(identity function)로 "x"를 입력하면 "x"를 출력
        System.out.println(f2.apply("AAA"));

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate();

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));

        String str1 = "abc";
        String str2 = "abc";

        Predicate<String> p2 = Predicate.isEqual(str1); // str1, str2 비교한 것
        System.out.println(p2.test(str2));
        // boolean result = Predicate.isEqual(str1).test(str2) == boolean result = str1.equals(str2)
    }
}
