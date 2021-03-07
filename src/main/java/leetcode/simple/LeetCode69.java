package leetcode.simple;

import leetcode.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class LeetCode69 {

    public static int mySqrt(int x) {
        // 二分法
        // 开始下标
        int begin = 0;
        // 结束下标
        int end = x;
        int ans = -1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            System.out.println("mid:"+ mid);
            if ((long) mid * mid <= x) {
                ans = mid;
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));

        List<String> names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);

    }


}
