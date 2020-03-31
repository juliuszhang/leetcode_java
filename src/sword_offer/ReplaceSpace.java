package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/31 10:18
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                ans.append("%20");
            } else {
                ans.append(chars[i]);
            }
        }
        return ans.toString();
    }
}
