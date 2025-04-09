import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;

        // 첫 번째 문자를 처리하기 위한 변수
        // 닫는 괄호 ')'가 첫 번째로 나올 일은 없지만, 예외를 방지하기 위해 조건을 추가
        char first = input.charAt(0);
        if (first == '(') {
            stack.add(first); // 여는 괄호 '('는 스택에 추가
        }

        // 문자열의 두 번째 문자부터 반복
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                // 여는 괄호 '('는 스택에 추가
                stack.add(c);
            } else if (c == ')' && input.charAt(i - 1) == '(') {
                // 닫는 괄호 ')'이고, 이전 문자가 여는 괄호 '('인 경우
                // 이는 레이저를 의미하므로 스택에서 하나를 제거하고
                // 현재 스택에 남아 있는 여는 괄호의 개수를 더함 (레이저로 자른 조각의 개수)
                stack.pop();
                count += stack.size();
            } else {
                // 닫는 괄호 ')'이고, 이전 문자가 여는 괄호가 아닌 경우
                // 이는 쇠막대기의 끝을 의미하므로 스택에서 하나를 제거하고
                // 조각 하나를 추가
                stack.pop();
                count++;
            }
        }

        // 최종적으로 계산된 조각의 개수를 출력
        System.out.println(count);
    }
}