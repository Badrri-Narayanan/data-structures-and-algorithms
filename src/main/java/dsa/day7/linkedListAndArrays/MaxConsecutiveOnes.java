package dsa.day7.linkedListAndArrays;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = {1,1,0,1,1,1};
		
		System.out.println("max consecutive 1's = " + findMaxConsecutiveOnes(nums));
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsec = 0, consec = 0;
        
        for(int n: nums) {
        	if(n != 1) {
        		consec = 0;
        	} else {
        		consec++;
        		if(maxConsec < consec) 
        			maxConsec = consec;
        	}
        }
        
        return maxConsec;
    }
}
