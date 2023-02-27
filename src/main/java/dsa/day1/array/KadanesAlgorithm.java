package dsa.day1.array;

public class KadanesAlgorithm {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("max sum = " + maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
		if(nums.length == 1) {
            return nums[0];
        }
        
        boolean isAllNegative = true;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                isAllNegative = false;
                break;
            }
        }
		
		int sum = 0, start = 0, stop = 0, max = Integer.MIN_VALUE;
		
		if(isAllNegative) {
            for(int i=0; i<nums.length; i++) {
                if(max < nums[i]) {
                    max = nums[i];
                }
            }
            
            return max;
        }
		
		for(int i=0; i<nums.length; i++) {
			sum+=nums[i];
			if(sum < 0) {
				sum=0;
				start = i+1;
			}
			
			if(max<sum) {
				max = sum;
				stop = i;
			}
		}
		
		System.out.println("start = " + start + " stop = " + stop);
		
		for(int i=start; i<=stop; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		return max;
    }
}
