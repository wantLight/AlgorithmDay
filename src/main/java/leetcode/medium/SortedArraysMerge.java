package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并N个长度为L的有序数组为一个有序数组
 *
 * 使用PriorityQueue实现最小堆，需要定义一个指针数组，用于保存这N个数组的index，
 * 定义Node类用于保存当前数值（value）和该数字所在的数组序号（idx），并且覆写Comparetor<Node>的compare方法实现自定义排序。PriorityQueue的offer()和poll()方法时间复杂度均为logn。
 *
 * 思路：首先将N个数组的第一位放到PriorityQueue，循环取出优先队列的首位（最小值）放入result数组中，
 * 并且插入该首位数字所在数组的下一个数字（如果存在），直到所有数字均被加入到result数组即停止（N*L）次。
 */
public class SortedArraysMerge {

    static class Node {
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", idx=" + idx +
                    '}';
        }
    }

    public static int[] MergeArrays(int[][] arr) {
        int N = arr.length, L;
        if (N == 0)//此时传入数组为空
            return new int[0];
        else {//判断数组是否符合规范
            L = arr[0].length;
            for (int i = 1; i < N; i++)
                if (arr[i].length != L)
                    return new int[0]; //此时数组不规范
        }
        int[] result = new int[N * L];
        int[] index = new int[N];
        Arrays.fill(index, 0, N, 0);
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.value < n2.value)
                    return -1;
                else if (n1.value > n2.value)
                    return 1;
                else
                    return 0;
            }
        });
        for (int i = 0; i < N; i++) {
            Node node = new Node(arr[i][index[i]++], i);
            System.out.println(node);
            queue.offer(node);
        }

        System.out.println(Arrays.toString(index));
        int idx = 0;
        while (idx < N * L) {
            Node minNode = queue.poll();
            result[idx++] = minNode.value;
            if (index[minNode.idx] < L) {
                queue.offer(new Node(arr[minNode.idx][index[minNode.idx]], minNode.idx));
                index[minNode.idx]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{ {1,2,3,4}, {2,4,6,8}, {6,7,8,9} };
        System.out.println(Arrays.toString(MergeArrays(arr)));
    }
}
