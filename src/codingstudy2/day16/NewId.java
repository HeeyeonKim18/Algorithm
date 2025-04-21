package codingstudy2.day16;

import java.util.Stack;

/**
 * 아이디 규칙
 * 길이: 3 ~ 15
 * 문자: 알파벳 소문자, 숫자, '-', '_', '.'
 * 마침표는 처음과 끝에 사용 x, 연속으로 사용 x
 * 
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */
public class NewId {
    public static void main(String[] args) {
        // String id = "...!@BaT#*..y.abcdefghijklm";
        // String id = "z-+.^.";
        // String id = "=.=";
        // String id = "123_.def";
        String new_id = "abcdefghijklmn.p";
        char[] charId = new_id.toCharArray();

        Stack<Character> stack = new Stack<>();
        Character first = charId[0];
        if (Character.isUpperCase(first)) {
            first = Character.toLowerCase(first);
        }
        if (Character.isDigit(first) || Character.isLowerCase(first) || first == '-' || first == '_' || first == '.') {
            stack.add(first);
        }
        for (int i = 1; i < charId.length; i++) {
            Character c = charId[i];
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }
            if (!Character.isDigit(c) && c != '-' && c != '_' && c != '.' && !Character.isLowerCase(c)) {
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == '.' && c == '.') {
                continue;
            }

            stack.add(c);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != '.' && stack.get(0) != '.')
                break;
            if (!stack.isEmpty() && stack.peek() == '.') {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.get(0) == '.') {
                stack.remove(0);
            }
        }

        if (stack.isEmpty()) {
            stack.add('a');
        }

        if (stack.size() >= 16) {
            while (stack.size() >= 16 || stack.peek() == '.') {
                stack.pop();
            }
        }

        if (stack.size() <= 2) {
            while (stack.size() < 3) {
                stack.add(stack.peek());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
