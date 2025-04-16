package codingstudy2.day13;

public class JadenCase {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                idx = -1;

            if (Character.isDigit(c)) {
                sb.append(c);
                idx++;
                continue;
            }

            if (idx == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }

            idx++;
        }
        System.out.println(sb);
    }
}
