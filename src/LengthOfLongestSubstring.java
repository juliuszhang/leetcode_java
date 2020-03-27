import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yibozhang
 * @date 2020/3/27
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口
     */
    private Set<Character> window = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int ans = 0;
        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            if (window.contains(c)) {
                window.remove(chars[start++]);
            } else {
                window.add(c);
                ans = Math.max(ans, i - start + 1);
                i++;
            }

        }
        return ans;
    }

}
