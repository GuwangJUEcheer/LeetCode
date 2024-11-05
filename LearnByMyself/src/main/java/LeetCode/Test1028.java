package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Test1028 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k =3;
        rotate(nums,3);
    }

    public static void rotate(int[] nums, int k) {

      //step 1 计算顺序
        int len = nums.length;
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i = 0;i<len;i++){
            if(i+k<len){
              hashMap.put(i+k,nums[i]);
            } else{
                hashMap.put((i+k)%len,nums[i]);
            }
        }

        for (int i = 0;i<len;i++){

            nums[i] = hashMap.get(i);
            System.out.println(nums[i] +",");
        }
    }
}
