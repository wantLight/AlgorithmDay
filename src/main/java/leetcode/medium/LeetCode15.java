package leetcode.medium;

import java.util.*;

/**
 * 三数之和 https://leetcode-cn.com/problems/3sum
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 */
public class LeetCode15 {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int length = nums.length;
        HashMap numMap = new HashMap();
        for (int i = 0; i < length; i++) {
            numMap.put(nums[i],i);
        }

        for (int i = 0; i < length; i++) {
            int num1 = nums[i];
            for (int j = i+1; j < length; j++) {
                int num2 = nums[j];
                int num3 = -(num1 + num2);
                if (numMap.get( num3 ) != null && (int)numMap.get(num3) > i+1 && (int)numMap.get(num3) != j ){
                    List<Integer> myNum = new ArrayList<>();
                    myNum.add(num1);
                    myNum.add(num2);
                    myNum.add(num3);
                    answer.add(myNum);
                }
            }
        }
        return answer;
    }
}
