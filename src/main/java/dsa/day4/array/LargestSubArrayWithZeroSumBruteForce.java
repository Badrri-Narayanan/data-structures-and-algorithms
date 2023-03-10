package dsa.day4.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestSubArrayWithZeroSumBruteForce {
	public static void main(String[] args) {
		int[] arr = {1, 3, -1, 4, -4};
		List<Integer> tempArr = Arrays.stream(arr).boxed().toList();
		int ans = LongestSubsetWithZeroSum(tempArr);
		System.out.println("Longest sub set = " + ans);
	}
	
	public static int LongestSubsetWithZeroSum(List<Integer> arr) {
		int longestSubArryWithSumZero = 0;
		
		List<List<Integer>> subArrays = getSubArrays(arr);
		
		for(List<Integer> subArray: subArrays) {
			int sum = 0;
			for(int n: subArray)
				sum += n;
			
			if(sum == 0 && longestSubArryWithSumZero < subArray.size()) {
				longestSubArryWithSumZero = subArray.size();
			}
		}
		
		return longestSubArryWithSumZero;
	}

	private static List<List<Integer>> getSubArrays(List<Integer> arr) {
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i=0; i<arr.size(); i++) {
			for(int j=i; j<arr.size(); j++) {
				List<Integer> subArr = new ArrayList<>();
				for(int k=i; k<=j; k++) {
					subArr.add(arr.get(k));
				}
				result.add(subArr);
			}
		}
		return result;
	}
}
