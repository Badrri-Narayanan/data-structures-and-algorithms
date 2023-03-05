package dsa.day3.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElementOfMatrix {
	public static void main(String[] args) {
		int[] arr = {2,2,1,1,1,2,2};
		System.out.println("Major Element = " + majorityElement(arr));
	}
	
	public static int majorityElement(int[] nums) {
        Map<Integer, Integer> occurence = new HashMap<>();
        
        for(int n: nums) {
        	if(occurence.get(n) == null)
        		occurence.put(n, 1);
        	else
        		occurence.put(n, occurence.get(n) + 1);
        }
        
        int majorElement = 0, max = 0;
        
        for(Entry<Integer, Integer> entry: occurence.entrySet()) {
        	if(max < entry.getValue()) {
        		max = entry.getValue();
        		majorElement = entry.getKey();
        	}
        }
        
        return majorElement;
    }
}
