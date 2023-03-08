package dsa.day4.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {-3,4,3,90};
		int target = 0;
		System.out.println("Pairs = " + Arrays.toString(twoSum(nums, target)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hash = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            if(hash.get(target - nums[i]) != null && hash.get(target - nums[i]) != i) {
                ans[0] = i;
                ans[1] = hash.get(target - nums[i]);
                break;
            }
            hash.put(nums[i], i);
        }
        
        return ans;
    }
}
