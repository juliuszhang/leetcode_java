package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/31 13:57
 */
public class StrToInt {

    public int strToInt(String str) {
        if ("".equals(str)) return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        boolean negative = false;
        int start = 0;
        if (firstChar == '+') {
            start = 1;
        } else if (firstChar == '-') {
            start = 1;
            negative = true;
        }

        int ans = 0;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isNumber(c)) break;
            int num = 0 - (c - '0');
            if ((Integer.MIN_VALUE - num) / 10 > ans) {
                ans = Integer.MIN_VALUE;
                break;
            } else {
                ans = ans * 10 + num;
            }
        }

        if (ans == Integer.MIN_VALUE && !negative) {
            return Integer.MAX_VALUE;
        } else {
            return negative ? ans : 0 - ans;
        }
    }

    private boolean isNumber(char c) {
        int num = c - '0';
        return num >= 0 && num <= 9;
    }

    public static void main(String[] args) {
        int i = new StrToInt().strToInt("-99999999999999");
        System.out.println(i);
    }

}
