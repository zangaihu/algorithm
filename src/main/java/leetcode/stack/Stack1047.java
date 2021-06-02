package leetcode.stack;

/**
 * @author sunhu
 * @date 2021/6/2 19:18
 */
public class Stack1047 {
    /*
    
    给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
    
    在 S 上反复执行重复项删除操作，直到无法继续删除。
    
    在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
    
    abbaca-->ca
     */

    public static void main(String[] args) {

        String ss = removeDuplicates("abbaca");
        System.out.println(ss);
    }

    public static String removeDuplicates(String s) {

        StringBuilder rep = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (rep.length() <= 0) {
                rep.append(c);
                continue;
            }
            if (c == rep.charAt(rep.length() - 1)) {
                rep.deleteCharAt(rep.length() - 1);
            } else {
                rep.append(c);
            }

        }
        return rep.toString();
    }
}
