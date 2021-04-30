package leetcode.stack;

import java.util.Stack;

/**
 * @author sunhu
 * @date 2021/4/30 16:00
 */
public class Stack1021 {

    /*
    输入："(()())(())"
    输出："()()()"
    解释：
    输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
    删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
    
    输入："(()())(())(()(()))"
    输出："()()()()(())"
    解释：
    输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
    删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
    
    
     */

    public static void main(String[] args) {

    }

    // TODO 代寫
    public static String removeOuterParentheses(String S) {

        Stack stack = new Stack();
        for (int i = 0; i < S.length(); i++) {

        }

        return null;
    }
}
