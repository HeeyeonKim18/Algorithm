package javaBook.stream;

import java.util.Optional;

public class Ex14_8 {
    public static void main(String[] args) {
        String str = null;
       // Optional<String> optVal = Optional.of(str);
        Optional<String> optVal1 = Optional.of("ABC");
        Optional<String> optVal2 = Optional.of(new String("abc"));

        //Optional<String> optVal3 = Optional.of(null); // 예외 발생
        Optional<String> optVal4 = Optional.ofNullable(null);   // 가능

        Optional<String> optVal5 = Optional.<String>empty();

//        String str1 = optVal.orElseGet(()->new String("AAA"));
//        System.out.println(str1);

        Optional.ofNullable(str).ifPresent(System.out::println);


    }
}
