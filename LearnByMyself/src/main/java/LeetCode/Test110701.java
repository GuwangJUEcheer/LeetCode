package LeetCode;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//注意：必须在不复制数组的情况下尽量原地对数组进行操作。
//
//示例
//示例 1:
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
//示例 2:
//输入: nums = [0]
//输出: [0]
//
//提示
//1 <= nums.length <= 10^4
//        -2^31 <= nums[i] <= 2^31 - 1
public class Test110701 {

    public void moveZeros(int[] nums) {

        int index = 0;
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) {
                continue;
            }

            if (index < i) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < count; i++) {

            nums[i] = 0;
        }
    }
}

