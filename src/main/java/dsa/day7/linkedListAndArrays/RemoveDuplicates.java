package dsa.day7.linkedListAndArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		int k = removeDuplicates(nums);
		
		System.out.println(Arrays.toString(nums) + " .k = " + k);
	}
	
	public static int removeDuplicates(int[] nums) {
        int k = 0;
        Set<Integer> hash = new HashSet<>();
        
        for(int n: nums) {
        	hash.add(n);
        }
        k = hash.size();
        
        List<Integer> result = hash.stream().sorted().toList();
        
        for(int i=0; i<k; i++) {
        	nums[i] = result.get(i);
        }
        return k;
    }
}
