package javaBook.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 람다식을 더 간단하게 만들 수 있다 = 메서드 참조
 * 클래스명::메서드이름
 */
public class Exercise_Ch14_13 {
    public static void main(String[] args) {
//        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;
        System.out.println(f2.apply("100") + 200);

        /**
         * 생성자 파라미터 없을 때
         */
//        Supplier<MyClass> s = () -> new MyClass();
        Supplier<MyClass> s = MyClass::new;
        MyClass mc = s.get();
        System.out.println(mc);

        /**
         * 생성자 파라미터 입력해야 할 때
         * 더 이상 Supplier가 아님 Function으로 변경해야함
         */
//        Function<Integer,MyClass> my = (i) -> new MyClass();
        Function<Integer, MyClass> my = MyClass::new;
        System.out.println(my.apply(100));

        /**
         * 배열 생성시 배열 길이를 설정해야 하기 때문에
         * Function 사용
         */
//        Function<Integer, int[]> f = x -> new int[x];
        Function<Integer, int[]> f = int[]::new;
        System.out.println(f.apply(100).length);
    }
}

class MyClass {
    int iv;

    public MyClass(int iv) {
        this.iv = iv;
    }

    public MyClass() {
    }
}
