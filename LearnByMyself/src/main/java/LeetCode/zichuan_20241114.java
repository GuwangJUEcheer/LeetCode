package LeetCode;

import java.util.HashMap;

/*
* 题目：560. 和为 K 的子数组

难度：中等

题目描述
给你一个整数数组 nums 和一个整数 k，请你统计并返回该数组中和为 k 的子数组的个数。

子数组是数组中元素的连续非空序列。

示例
示例 1:

输入：nums = [1,1,1], k = 2
输出：2
示例 2:

输入：nums = [1,2,3], k = 3
输出：2
提示：
1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7
* */
public class zichuan_20241114 {

    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < ; i++) {
            //如果某个j开始到i i-j的和是k 说明这个子串的数量是i-j
            count += hashMap.getOrDefault(sums[i]-k,0);
            hashMap.put(sums[i],hashMap.getOrDefault(sums[i],0)+1);
        }
        return count;
    }
}
