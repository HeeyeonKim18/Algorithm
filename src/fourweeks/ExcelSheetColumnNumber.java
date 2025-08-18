package fourweeks;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String s = "AAA";
        System.out.println(titleToNumber(s));
    }

    private static int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
