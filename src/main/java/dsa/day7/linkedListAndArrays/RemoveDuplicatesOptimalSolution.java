package dsa.day7.linkedListAndArrays;

import java.util.Arrays;

public class RemoveDuplicatesOptimalSolution {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		int k = removeDuplicates(nums);
		
		System.out.println(Arrays.toString(nums) + " .k = " + k);
	}

	private static int removeDuplicates(int[] nums) {
		if(nums.length == 0)
			return 0;
		
		int i =0, j =i+1;
		
		while(j<nums.length) {
			if(nums[i] != nums[j]) {
				nums[i+1] = nums[j];
				i++;
			} else {
				j++;
			}
		}
		
		return i+1;
	}
}
