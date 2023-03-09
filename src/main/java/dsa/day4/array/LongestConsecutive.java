package dsa.day4.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        
        for(int n: nums)
            numbers.add(n);
        
        int longestConsecutive = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(!numbers.contains(nums[i]-1)) {
                int consec = 1;
                while(numbers.contains(nums[i]+consec))
                    consec++;
                
                if(longestConsecutive < consec)
                    longestConsecutive = consec;
            }
        }
        
        return longestConsecutive;
    }
}
