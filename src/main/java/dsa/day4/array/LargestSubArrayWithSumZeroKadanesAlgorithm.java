package dsa.day4.array;

import java.util.Arrays;
import java.util.List;

public class LargestSubArrayWithSumZeroKadanesAlgorithm {
	public static void main(String[] args) {
		int[] arr = {1, 3, -1, 4, -4};
		List<Integer> tempArr = Arrays.stream(arr).boxed().toList();
		int ans = LongestSubsetWithZeroSum(tempArr);
		System.out.println("Longest sub set = " + ans);
	}

	private static int LongestSubsetWithZeroSum(List<Integer> arr) {
		int longestSubSetWithSumZero = 0;
		int start = 0, stop = 0, sum = 0;
		
		for(int i=0; i<arr.size(); i++) {
			sum += arr.get(i);
			if(sum == 0) {
				//
			}
		}
		return longestSubSetWithSumZero;
	}

	
}
