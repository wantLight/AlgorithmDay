package leetcode.simple.arr;

import java.util.Arrays;

/**
 *  最小的k个数
 * 腾讯面试题
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 * 快速排序，
 */
public class LeetCode40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    // 找到下标为k-1的数
    private int[] quickSearch(int[] nums, int start, int end, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, start, end);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, start, j - 1, k): quickSearch(nums, j + 1, end, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。

    /**
     * 单边循环法 --- 快排切分
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] nums, int start, int end) {
        // 取第一个元素作为基准元素
        int v = nums[start];
        // pre指针
        int pre = start;
        int temp;

        for (int i = start+1; i <= end; i++) {
            if (nums[i] < v){
                // pre指针前移
                pre++;
                // 交换pre所在值与i所在值
                temp = nums[i];
                nums[i] = nums[pre];
                nums[pre] = temp;
            }
        }
        // 循环结束后
        temp = nums[pre];
        nums[start] = temp;
        nums[pre] = v;
        return pre;



//        int i = start, j = end + 1;
//        while (true) {
//            while (++i <= end && nums[i] < v);
//            while (--j >= start && nums[j] > v);
//            if (i >= j) {
//                break;
//            }
//            int t = nums[j];
//            nums[j] = nums[i];
//            nums[i] = t;
//        }
//        nums[start] = nums[j];
//        nums[j] = v;
    }

}
