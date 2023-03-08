package dsa.day3.array;

public class ReversedPairsOfArray {
	public static void main(String[] args) {
		int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		System.out.println("Reversed Pairs = " + reversePairs(nums));
		System.out.println(Integer.MAX_VALUE);
	}
	
	public static int reversePairs(int[] nums) {
        int numberOfReversedPairs = 0;
        
        for(int i=0; i<nums.length; i++)
        	for(int j=i; j<nums.length; j++)
        		if(i<j && nums[i] > 2 * nums[j])
        			numberOfReversedPairs++;
        
        return numberOfReversedPairs;
    }
}
