package dsa.day7.linkedListAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumOptimalSolution {
	public static void main(String[] args) {
//		int[] nums = {-1,0,1,2,-1,-4};
		int[] nums = {-2,0,0,2,2};
		
		List<List<Integer>> result = threeSum(nums);
		
		System.out.println(result);
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i=0; i<nums.length-2; i++) {
			if(i == 0 || (i>0 && nums[i] != nums[i-1])) {
				int low = i+1, high = nums.length-1, sum = 0-nums[i];
				while(low < high) {
					if(nums[low] + nums[high] == sum) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						
						while(low < high && nums[low] == nums[low+1]) {
							low++;
						}
						
						while(low < high && nums[high] == nums[high-1]) {
							high--;
						}
						low++;
					} else if((nums[low] + nums[high]) < sum) {
						low++;
					} else {
						high--;
					}
				}
			}
		}
		
		return result;
	}
}
