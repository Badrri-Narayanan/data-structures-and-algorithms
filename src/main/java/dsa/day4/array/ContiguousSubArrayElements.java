package dsa.day4.array;

import java.util.ArrayList;
import java.util.List;

public class ContiguousSubArrayElements {
	public static void main(String[] args) {
		int[] arr = {1, 3, -1, 4, -4};
		List<List<Integer>> subArrays = getSubArrays(arr);
		System.out.println(subArrays);
	}

	private static List<List<Integer>> getSubArrays(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				List<Integer> subArr = new ArrayList<>();
				for(int k=i; k<=j; k++) {
					subArr.add(arr[k]);
				}
				result.add(subArr);
			}
		}
		return result;
	}
}
