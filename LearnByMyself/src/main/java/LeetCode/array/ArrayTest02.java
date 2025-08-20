package LeetCode.array;

import java.util.*;

public class ArrayTest02 {

	/**
	 * 209. Minimum Size Subarray Sum
	 *
	 * @param target
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen(int target, int[] nums) {
		int result = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= target) {
				result = Math.min(result, i - left + 1);
				sum -= nums[left++];
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
		System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
	}

	public int totalFruit(int[] fruits) {
		Map<Integer, Integer> map = new HashMap<>();
		int left = 0;
		int res = 0;
		for (int i = 0; i < fruits.length; i++) {
			map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
			while (map.size() > 2) {
				map.put(fruits[left], map.get(fruits[left]) - 1);
				if (map.get(fruits[left]) == 0) {
					map.remove(fruits[left]);
				}
				left++;
			}
			res = Math.max(res, i - left + 1);
		}
		return res;
	}

	public String minWindow(String s, String t) {
		if (s.length() < t.length()) return "";

		char[] sCharArray = s.toCharArray();
		char[] tCharArray = t.toCharArray();

		Map<Character, Integer> hasExistedMap = new HashMap<>();
		for (char tChar : tCharArray) {
			hasExistedMap.put(tChar, hasExistedMap.getOrDefault(tChar, 0) + 1);
		}

		int res = Integer.MAX_VALUE;
		int allNeed = hasExistedMap.size();
		int start = 0;
		int required = 0;
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			char c = sCharArray[right];
			if (hasExistedMap.containsKey(c)) {
				map.put(c, map.getOrDefault(c, 0) + 1);
				if (Objects.equals(map.get(c), hasExistedMap.get(c))) {
					required++;
				}
			}

			while (required == allNeed) {
				if (right - left + 1 < res) {
					start = left;
					res = right - left + 1;
				}
				char leftChar = sCharArray[left];
				if (hasExistedMap.containsKey(leftChar)) {
					if (Objects.equals(map.get(leftChar), hasExistedMap.get(leftChar))) {
						required--;
					}
					map.put(leftChar, map.get(leftChar) - 1);
				}
				left++;
			}
		}

		return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
	}
}
