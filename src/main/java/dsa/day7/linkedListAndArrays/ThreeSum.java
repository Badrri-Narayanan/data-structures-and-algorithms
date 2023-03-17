package dsa.day7.linkedListAndArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		
		List<List<Integer>> result = threeSum(nums);
		
		System.out.println(result);
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, List<Integer>> hash = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
        	List<Integer> indices = hash.get(nums[i]) == null 
        							? new ArrayList<>() 
        							: hash.get(nums[i]);
    		indices.add(i);
    		hash.put(nums[i], indices);
        }
        
        for(int i=0; i<nums.length; i++) 
        	for(int j=i+1; j<nums.length; j++) {
        		if(hash.get(0 - nums[i] - nums[j]) != null) {
        			List<Integer> indices = hash.get(0 - nums[i] - nums[j]);
        			for(int k: indices) {
        				if(i != k && j != k) {
        					List<Integer> ans = new ArrayList<>();
            				ans.add(nums[i]);
            				ans.add(nums[j]);
            				ans.add(nums[k]);
            				Collections.sort(ans);
            				result.add(ans);
        				}
        			}
        		}
        	}

        return result.stream().toList();
    }
}
