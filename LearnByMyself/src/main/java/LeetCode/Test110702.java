package LeetCode;
//给定一个长度为 n 的整数数组 height。数组中的每个元素表示竖线的高度。找出其中的两条竖线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//返回容器可以存储的最大水量。
//
//注意：你不能倾斜容器。
//
//示例
//示例 1:
//输入: height = [1,8,6,2,5,4,8,3,7]
//输出: 49
//解释：在此情况下，容器能够容纳水（蓝色部分）的最大值为 49。
//
//示例 2:
//输入: height = [1,1]
//输出: 1
public class Test110702 {

    public int maxArea(int[] nums){

        int left = 0;
        int right = nums.length -1;
        int res = 0;
        int area = 0;
        while(l < r){
            area = Math.min(nums[left],nums[right])*(right-left);
            res = Math.max(area,res);
            if(nums[right] > nums[left]){
                l++;
            }else{
                r--;
            }
        }
    }
}
