package codingstudy2.day16;

public class NewIdByOthers {
    public static void main(String[] args) {
        // String id = "...!@BaT#*..y.abcdefghijklm";
        // String id = "z-+.^.";
        // String id = "=.=";
        String id = "123_.def";

        id = id.toLowerCase();
        id = id.replaceAll("[^a-z0-9._-]", "");
        id = id.replaceAll("[.]{2,}", ".");
        id = id.replaceAll("^[.][.]$", "");
        id = id.isEmpty() ? "a" : id;
        if (id.length() >= 16)
            id = id.substring(0, 15);
        id = id.replaceAll("[.]$", "");
        StringBuilder sb = new StringBuilder(id);
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        id = sb.toString();
        System.out.println(id);

    }
}
