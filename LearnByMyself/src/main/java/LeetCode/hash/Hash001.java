package LeetCode.hash;

import java.util.*;

public class Hash001 {

	public static void main(String[] args) {
		int[] testNums = new int[]{1, 0, 1, 2, -1, -4};
		System.out.println(threeSums(testNums));
	}

	//三数之和
	public static List<List<Integer>> threeSums(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// 跳过相同的起点，避免重复三元组
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int left = i + 1;
			int right = nums.length - 1;
			int target = nums[i];
			while (left < right) {
				if (nums[left] + nums[right] + target > 0) {
					right--;
				} else if (nums[left] + nums[right] + target < 0) {
					left++;
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(nums[left]);
					list.add(nums[i]);
					list.add(nums[right]);
					res.add(list);
					while (left < right && nums[left] == nums[left + 1]) left++;
					while (left < right && nums[right] == nums[right - 1]) right--;
					left++;
					right--;
				}
			}
		}
		return res;
	}

	//数组交集
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		for (int num : nums1) set1.add(num);
		Set<Integer> set2 = new HashSet<>();
		for (int num : nums2) {
			if (set1.contains(num)) set2.add(num);
		}
		return set2.stream().mapToInt(i -> i).toArray();
	}

	public static List<List<Integer>> threeSums2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) return res;
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int target = nums[i];
			left = i + 1;
			while (left < right) {
				if (nums[left] + nums[right] + target > 0) {
					right--;
				} else if (nums[left] + nums[right] + target < 0) {
					left++;
				} else {
					res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
					while (left < right && nums[left] == nums[left + 1]) left++;
					while (left < right && nums[right] == nums[right - 1]) right--;
					left++;
					right--;
				}
			}
		}
		return res;
	}

	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		//第一步分组 两个两个分组
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
			}
		}
		//第二步 找到对应的0-nums3[i]-nums[i]
		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {
				if (map.containsKey(-nums3[i] - nums4[j])) {
					res += map.get(-nums3[i] - nums4[j]);
				}
			}
		}
		return res;
	}

	//四数之和
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		//剪枝
		List<List<Integer>> res = new ArrayList<>();
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] > target && target > 0 && nums[k] > 0) continue;
			if (k > 0 && nums[k] == nums[k - 1]) continue;
			for (int i = k + 1; i < nums.length; i++) {
				int left = i + 1;
				int right = nums.length - 1;
				if (nums[i] + nums[k] > target && target > 0) continue;
				if (i > k + 1 && nums[i] == nums[i - 1]) continue;
				while (left < right) {
					if (nums[left] + nums[right] + nums[i] + nums[k] > target) {
						right--;
					} else if (nums[left] + nums[right] + nums[i] + nums[k] < target) {
						left++;
					} else {
						res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[left], nums[right])));
						while (left < right && nums[left] == nums[left + 1]) left++;
						while (left < right && nums[right] == nums[right - 1]) right--;
						left++;
						right--;
					}
				}
			}
		}
		return res;
	}
}

