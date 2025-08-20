package LeetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Squares of a Sorted Array
 */
public class ArrayTest01 {

	public int[] sortedSquares(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		int index = length - 1;
		int left = 0;
		int right = length - 1;
		while (left <= right && index >= 0) {
			if (Math.abs(nums[left]) > Math.abs(nums[right])) {
				result[index] = nums[left] * nums[left];
				left++;
			} else {
				result[index] = nums[right] * nums[right];
				right--;
			}
			index--;
		}
		return result;
	}

	public String minWindow(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Map<Character, Integer> map1 = new HashMap<>();
		for (char tChar : tArray) {
			map1.put(tChar, map1.getOrDefault(tChar, 0) + 1);
		}
		int allNeed = map1.size();
		int required = 0;
		Map<Character, Integer> map2 = new HashMap<>();
		int left = 0;
		int start = 0;
		int resLen = Integer.MAX_VALUE;
		for (int right = 0; right < s.length(); right++) {
			char rightChar = sArray[right];
			if (map1.containsKey(rightChar)) {
				map2.put(rightChar, map2.getOrDefault(rightChar, 0) + 1);
				if (map2.get(rightChar) == map1.get(rightChar)) {
					required++;
				}
			}
			while (required == allNeed) {
				if (right - left + 1 < resLen) {
					start = left;
					resLen = right - left + 1;
				}
				char leftChar = sArray[left];
				if (map1.containsKey(leftChar)) {
					if (map2.get(leftChar) == map1.get(leftChar)) {
						required--;
					}
					map2.put(leftChar, map2.getOrDefault(leftChar, 0) - 1);
					left++;
				}
			}
		}
		return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
	}

	//[1,2,3,2,2]
	public int totalFruit(int[] fruits) {
		Map<Integer, Integer> map = new HashMap<>();
		int left = 0;
		int result = 0;
		for (int right = 0; right < fruits.length; right++) {
			result = Math.max(result, right - left + 1);
			map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
			while (left < right && map.size() > 2) {
				map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
				if (map.get(fruits[left]) == 0) {
					map.remove(fruits[left]);
				}
				left++;
			}
		}
		return result;
	}
}
