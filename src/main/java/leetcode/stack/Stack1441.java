package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1441. 用栈操作构建数组
 * 
 * @author sunhu
 * @date 2021/4/28 18:34
 */
public class Stack1441 {

    /*
    给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
    
    请使用下述操作来构建目标数组 target ：
    
    Push：从 list 中读取一个新元素， 并将其推入数组中。
    Pop：删除数组中的最后一个元素。
    如果目标数组构建完成，就停止读取更多元素。
    题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
    
    请返回构建目标数组所用的操作序列。
    
    题目数据保证答案是唯一的。   
     */

    public static void main(String[] args) {
        List<String> list = buildArray(new int[] {2, 3, 4}, 4);
        System.out.println(list);
    }

    public static List<String> buildArray(int[] target, int n) {

        List<String> list = new ArrayList<>();
        for (int i = 1, j = 0; j < target.length && i <= n; i++) {
            list.add("Push");
            if (target[j] != i) {
                list.add("Pop");
                continue;
            }
            j++;
        }

        return list;
    }

    public static List<String> buildArrayStack(int[] target, int n) {

        List<String> list = new ArrayList<>();
        Stack stack = new Stack();

        return list;
    }

}
