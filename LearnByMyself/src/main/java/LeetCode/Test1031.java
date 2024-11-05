package LeetCode;

public class Test1031 {
    public static int maxProfit(int[] prices) {
        int curr_hold = -Integer.MAX_VALUE;
        int curr_cash = 0;
        for (int price : prices) {
            int pre_cash = curr_cash;
            int pre_hold = curr_hold;
            curr_hold = Math.max(pre_hold, pre_cash - price);
            curr_cash = Math.max(pre_cash, pre_hold + price);
        }
        return curr_cash;
    }

    public static void main(String[] args) {
        int[] num1= new int[]{2,4,1};
        System.out.println(maxProfit(num1));
    }
}
