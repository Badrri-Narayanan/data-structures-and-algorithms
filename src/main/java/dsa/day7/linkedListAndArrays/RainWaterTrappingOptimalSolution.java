package dsa.day7.linkedListAndArrays;

public class RainWaterTrappingOptimalSolution {
	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println("Amount of water trapped = " + trap(nums));
	}

	private static int trap(int[] nums) {
		int left=0, right=nums.length-1, result = 0, 
				maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
		
		while(left <= right) {
			if(nums[left] <= nums[right]) {
				if(nums[left] >= maxLeft) 
					maxLeft = nums[left];
				else
					result += maxLeft - nums[left];
				
				left++;
			} else {
				if(nums[right] >= maxRight)
					maxRight = nums[right];
				else
					result += maxRight - nums[right];
				
				right--;
			}
		}
		
		return result;
	}
}
