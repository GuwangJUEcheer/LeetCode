package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Test1103 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        Set<Integer> visited = new HashSet<Integer>();

        while (!queue.isEmpty()) {
            int[] nowArray = queue.poll();
            int currentIndex = nowArray[0];
            int steps = nowArray[1];
            for (int i = 1; i <= nums[currentIndex]; i++) {

                int newPosition = currentIndex + i;
                if (newPosition >= nums.length - 1) {
                    return steps + 1;
                }

                if (!visited.contains(newPosition)) {
                    visited.add(newPosition);
                    queue.offer(new int[]{newPosition, steps + 1});
                }
            }
        }

        return -1;
    }


    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int s = 0;
        int end = 0;
        int steps = 0;
        int fartherst =0;

        for(int i =0;i< nums.length;i++){
            fartherst = Math.max(fartherst,nums[i] + i);
            if(fartherst >= nums.length -1){
                steps++;
                return steps;
            }

            if (end == i){
                steps++;
                end = fartherst;
            }
        }

        return steps;
    }


//    public int hIndex(int[] citations) {
//
//        int[] temp = new int[n+1];
//        return 0;
//    }
}
