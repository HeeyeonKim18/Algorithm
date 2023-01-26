package javaBook.lambda;

public class Ex14_0 {
    public static void main(String[] args) {
//        Object obj = (a, b) -> a > b ? a : b;  // 람다식으로 익명 객체이다.
        Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };

//        int value = obj.max(3, 5); // 함수형 인터페이스
    }
}
