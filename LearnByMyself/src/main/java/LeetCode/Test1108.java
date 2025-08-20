package LeetCode;
//给你一个整数数组 nums，判断是否存在三个元素 nums[i]、nums[j]、nums[k] 满足 i != j、i != k 且 j != k，
// 并且满足 nums[i] + nums[j] + nums[k] == 0。请你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//示例
//示例 1:
//输入: nums = [-1,0,1,2,-1,-4]
//输出: [[-1,-1,2],[-1,0,1]]
//解释:
//不同的三元组是 [-1,0,1] 和 [-1,-1,2]，它们的和都是 0。
//
//示例 2:
//输入: nums = [0,1,1]
//输出: []
//解释: 唯一可能的三元组和不为 0。
//
//示例 3:
//输入: nums = [0,0,0]
//输出: [[0,0,0]]
//解释: 唯一可能的三元组和为 0。


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1108 {

	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums); // 先对数组进行排序

		for (int i = 0; i < n; i++) {
			// 跳过重复的nums[i]，避免重复三元组
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int target = -nums[i];
			int l = i + 1;
			int r = n - 1;

			while (l < r) {
				int sum = nums[l] + nums[r];

				if (sum == target) {
					// 找到符合条件的三元组
					res.add(Arrays.asList(nums[i], nums[l], nums[r]));

					// 跳过重复的nums[l]
					while (l < r && nums[l] == nums[l + 1]) l++;
					// 跳过重复的nums[r]
					while (l < r && nums[r] == nums[r - 1]) r--;

					// 移动指针
					l++;
					r--;
				} else if (sum < target) {
					l++;
				} else {
					r--;
				}
			}
		}
		return res;
	}
}
