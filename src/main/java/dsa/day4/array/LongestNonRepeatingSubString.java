package dsa.day4.array;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubString {
	public static void main(String[] args) {
//		String s = "abcabcbb";
//		String s = "aab";
		String s = "dvdf";
		int longest = lengthOfLongestSubstring(s);
		
		System.out.println("ans = " + longest);
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int longestSubStringWithoutAnyRepeat = 0, left=0, right=0;
		Map<Character, Integer> hash = new HashMap<>();
		
		while(right < s.length()) {
			if(hash.containsKey(s.charAt(right)))
				left = Math.max(hash.get(s.charAt(right))+1, left);
			
			hash.put(s.charAt(right), right);
			longestSubStringWithoutAnyRepeat = Math.max(longestSubStringWithoutAnyRepeat, right-left+1);
			right++;
		}
		
		return longestSubStringWithoutAnyRepeat;
    }
}
