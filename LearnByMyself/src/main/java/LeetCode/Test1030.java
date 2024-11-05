package LeetCode;

public class Test1030 {
    public static int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int price : prices) {
            min_price = Math.min(min_price, price);
            max_profit = Math.max(max_profit, price - min_price);
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int[] num1= new int[]{2,4,1};
        System.out.println(maxProfit(num1));
    }
}
