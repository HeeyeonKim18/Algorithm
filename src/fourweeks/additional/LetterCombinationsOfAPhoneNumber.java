package fourweeks.additional;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private static void backtrack(String digits, int idx, StringBuilder path, List<String> res) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }
        List<Character> letters = charToLetter(digits.charAt(idx));
        for (char ch : letters) {
            path.append(ch);
            backtrack(digits, idx + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private static List<Character> charToLetter(char c) {
        List<Character> list = new ArrayList<>();
        switch (c) {
            case '2':
                list.add('a');
                list.add('b');
                list.add('c');
                break;
            case '3':
                list.add('d');
                list.add('e');
                list.add('f');
                break;
            case '4':
                list.add('g');
                list.add('h');
                list.add('i');
                break;
            case '5':
                list.add('j');
                list.add('k');
                list.add('l');
                break;
            case '6':
                list.add('m');
                list.add('n');
                list.add('o');
                break;
            case '7':
                list.add('p');
                list.add('q');
                list.add('r');
                list.add('s');
                break;
            case '8':
                list.add('t');
                list.add('u');
                list.add('v');
                break;
            case '9':
                list.add('w');
                list.add('x');
                list.add('y');
                list.add('z');
                break;
        }
        return list;
    }

}
