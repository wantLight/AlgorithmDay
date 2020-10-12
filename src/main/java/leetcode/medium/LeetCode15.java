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

    /**
     * 暴力解法，还缺少去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length-2; i++) {
            int num1 = nums[i];
            for (int j = i+1; j < length-1; j++) {
                int num2 = nums[j];
                for (int k = j+1; k < length; k++) {
                    int num3 = nums[k];
                    if (0 == num3 + num1 + num2) {
                        List<Integer> myNum = new ArrayList<>();
                        myNum.add(num1);
                        myNum.add(num2);
                        myNum.add(num3);
                        answer.add(myNum);
                    }
                }
            }
        }
        return answer;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int length = nums.length;
        if (length < 3){
            return answer;
        }
        //  先对数组进行排序 (从小到大)
        Arrays.sort(nums);

        for (int i = 0; i < length-2; i++) {
            int i1 = nums[i];
            if (i1 > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            // 它的目标是找到两个相加为它相反的数
            int target = -nums[i];
            // 双指针开始循环
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    // 得到答案
                    answer.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    // 左右指针移动后还要考虑重复情况
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right++;
                } else if (nums[left] + nums[right] < target){
                    left++;
                } else {
                    right--;
                }
            }

        }



        return answer;
    }
}
