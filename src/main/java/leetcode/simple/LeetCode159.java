package leetcode.simple;

import leetcode.medium.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 *
 * 示例 1:
 * 输入: “eceba”
 * 输出: 3
 * 解释: t 是 “ece”，长度为3。
 *
 * 示例 2:
 * 输入: “ccaabbb”
 * 输出: 5
 * 解释: t 是 “aabbb”，长度为5。
 *
 * 利用集合的互异性，集合里只允许出现小于等于两个元素，但是计数器可以累加，就可以统计最长子串
 *
 */

public class LeetCode159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> set =new HashSet<>();
        int res = 0;
        for(int i = 0;i<s.length();i++){
            set.clear();
            int count =0;
            for(int j =i;j<s.length();j++){
                //如果在集合里，则count++；
                if(set.contains(s.charAt(j))){
                    count++;
                    res =Math.max(res,count);
                }
                //如果不在集合且集合大小小于2，把元素加入且count++
                else if(set.size()<2){
                    set.add(s.charAt(j));
                    count++;
                    res =Math.max(res,count);
                }
                //不满足情况，跳出本次循环
                else{
                    break;
                }
            }
        }
        return res;
    }

}
