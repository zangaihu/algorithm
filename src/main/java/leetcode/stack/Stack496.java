package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunhu
 * @date 2021/6/2 19:38
 */
public class Stack496 {

    /*
    给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
    
    请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
    
    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
    
     
    
    示例 1:
    
    输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
    输出: [-1,3,-1]
    解释:
    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     */

    public static void main(String[] args) {

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map map = new HashMap();
        Stack stack = new Stack();

        int len1 = nums1.length;
        int len2 = nums2.length;

        return null;
    }

}
