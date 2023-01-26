package javaBook.lambda;

public class Ex14_0 {
    public static void main(String[] args) {
//        Object obj = (a, b) -> a > b ? a : b;  // 람다식으로 익명 객체이다.

        /**
         * 이렇게 쓰면 너무 복잡하고
         * 코드가 길어짐
         * 람다식을 사용하면 보다 간결하게 작성가능
         */
        MyFunction f = (a, b) -> a > b ? a : b;
//        MyFunction f = new MyFunction() {
//            public int max(int a, int b) { // 오버라이딩 - 접근제어자는 좁게 못 바꿈
//                return a > b ? a : b;
//            }
//        };

        /**
         * 람다식을 다루기 위한 참조변수의 타입은
         * 함수형 인터페이스로 한다.
         */
        int value = f.max(3, 5); // 함수형 인터페이스
        System.out.println("value = " + value);
    }
}

@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함.
interface MyFunction {
    //    public abstract  int max(int a, int b); // 인터페이스의 모든 메서드는 public이면서 abstract이기 때문에 생략 가능함
    int max(int a, int b);
}