package dsa.day3.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement2 {
	public static void main(String[] args) {
		int[] arr = {2,1,1,3,1,4,5,6};
		System.out.println("Major Element = " + majorityElement(arr));
	}
	
	public static List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        
        Map<Integer, Integer> occurence = new HashMap<>();
        
        for(int n: nums) {
        	if(occurence.get(n) == null)
        		occurence.put(n, 1);
        	else
        		occurence.put(n, occurence.get(n) + 1);
        }
        
        for(Entry<Integer, Integer> entry : occurence.entrySet()) {
        	if(entry.getValue() > nums.length/3)
        		majorityElements.add(entry.getKey());
        }
        
        return majorityElements;
    }
}
