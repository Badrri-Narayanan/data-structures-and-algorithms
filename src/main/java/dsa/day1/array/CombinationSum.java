package dsa.day1.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,6,7};
		int target = 7;
		getNumberOfCombinationsWhichMatchTarget(0, target, arr, new ArrayList<Integer>());
	}

	private static void getNumberOfCombinationsWhichMatchTarget(int index, int target, int[] arr,
			List<Integer> ans) {
		if(target < 0)
			return;
		
		if(index == arr.length) {
			if(target == 0) {
				System.out.println(ans);
			}
			return;
		}
		
		if(arr[index] <= target) {
			ans.add(arr[index]);
			getNumberOfCombinationsWhichMatchTarget(index, target-arr[index], arr, ans);
			ans.remove(ans.size()-1);
		}
		getNumberOfCombinationsWhichMatchTarget(index+1, target, arr, ans);
	}
}
