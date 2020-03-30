package sword_offer;

import java.util.Stack;

/**
 * @author yibozhang
 * @date 2020/3/30 22:33
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        if("".equals(s)) return "";
        Stack<String> stack = new Stack<>();
        String[] strs = s.split(" ");
        for(String str:strs){
            if("".equals(str)) continue;
            stack.push(str);
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop()).append(" ");
        }

        return ans.substring(0, ans.length() - 1).toString();
    }

}
