package leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 *
 * 如果堆的元素个数小于 kk，就可以直接插入堆中。
 * 如果堆的元素个数等于 kk，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 kk 个数字的出现次数比当前值大，故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
 *
 */

public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }



    public int[] topKFrequent2(int[] nums, int k) {
        int[] res = new int[k];    // 结果数组
        Map<Integer, Integer> map = new HashMap();
        // 统计数组中各元素出现的次数
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        int maxTimes = 0;    // 出现最多的元素的出现次数
        // 找出出现次数最多的元素出现的次数
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxTimes){
                maxTimes = entry.getValue();
            }
        }

        // 按出现次数从大到小添加到结果数组
        while(k > 0){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == maxTimes){
                    res[k - 1] = entry.getKey();
                    k--;
                }
            }
            maxTimes--;
        }

        return res;
    }
}


