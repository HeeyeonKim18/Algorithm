package sparta_algorithm.firstweek;

import java.util.Scanner;

public class IsEven {
    public static void main(String[] args) {
        System.out.print("숫자를 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        isEven(sc.nextInt());
    }

    private static void isEven(int num){
        if(num % 2 == 0) System.out.println("짝수입니다.");
        else System.out.println("홀수입니다.");
    }
}
