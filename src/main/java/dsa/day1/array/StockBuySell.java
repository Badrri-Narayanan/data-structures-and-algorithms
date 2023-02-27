package dsa.day1.array;

public class StockBuySell {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println("Max profit = " + maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
        int max = 0, min=Integer.MAX_VALUE;
        
        for(int i=0; i<prices.length; i++) {
        	if(min > prices[i]) {
        		min = prices[i];
        	}
        	
        	if(min != Integer.MAX_VALUE && (prices[i] - min) > max) {
        		max = prices[i] - min;
        	}
        }
        
        return max;
    }
}
