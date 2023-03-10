package dsa.day4.array;

import java.util.Arrays;
import java.util.List;

public class LargestSubArrayWithSumZeroImproved {
	public static void main(String[] args) {
		int[] arr = {1, 3, -1, 4, -4};
		List<Integer> tempArr = Arrays.stream(arr).boxed().toList();
		int ans = LongestSubsetWithZeroSum(tempArr);
		System.out.println("Longest sub set = " + ans);
	}

	public static int LongestSubsetWithZeroSum(List<Integer> arr) {
		int largestSubArrayWithSumZero = 0;
		
		for(int i=0; i<arr.size(); i++) {
			int sum = 0;
			for(int j=i; j<arr.size(); j++) {
				sum += arr.get(j);
				
				if(sum == 0 && largestSubArrayWithSumZero < (j-i+1)) {
					largestSubArrayWithSumZero = j-i+1;
				}
			}
		}
		
		return largestSubArrayWithSumZero;
	}
}
