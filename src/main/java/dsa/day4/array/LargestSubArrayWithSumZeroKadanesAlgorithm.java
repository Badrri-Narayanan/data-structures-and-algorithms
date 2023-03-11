package dsa.day4.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubArrayWithSumZeroKadanesAlgorithm {
	public static void main(String[] args) {
		int[] arr = {1,-1,3,2,-2,-8,1,7,10,23};
		List<Integer> tempArr = Arrays.stream(arr).boxed().toList();
		int ans = LongestSubsetWithZeroSum(tempArr);
		System.out.println("Longest sub set = " + ans);
	}

	private static int LongestSubsetWithZeroSum(List<Integer> arr) {
		int longestSubSetWithSumZero = 0, sum = 0;
		Map<Integer, Integer> hash = new HashMap<>();
		
		for(int i=0; i<arr.size(); i++) {
			sum += arr.get(i);
			if(sum == 0) {
				longestSubSetWithSumZero = i+1;
			}
			if(hash.get(sum) != null) {
				int len = i - hash.get(sum);
				if(longestSubSetWithSumZero < len) {
					longestSubSetWithSumZero = len;
				}
			} else {
				hash.put(sum, i);
			}
		}
		
		return longestSubSetWithSumZero;
	}

	
}
