package dsa.day2.array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		
		System.out.println(findDuplicate(nums));
	}
	
	public static int findDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int i=0;
		
		for(; i<nums.length; i++) {
			if(!set.add(nums[i])) {
				break;
			}
		}
		
		return nums[i];
    }
}
