package ten;

/**
 * @author sunhu
 * @date 2020/11/30 11:31
 */
public class KMP {

    public static void main(String[] args) {

        String str1 = "abcdeabc";
        String str2 = "abc";
        System.out.println(method1(str1, str2));
    }

    public static int method1(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len) {
            // 元素相等，往后移动
            if (s1[i] == s1[j]) {
                i++;
                j++;
            } else {
                // 遇到不相等，i 回溯到上次的下一个位置 ，j=0
                i = i - j + 1; // 减去移动位置 ，+1
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }

}
