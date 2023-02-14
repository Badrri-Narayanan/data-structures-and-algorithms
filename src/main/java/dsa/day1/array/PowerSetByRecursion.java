package dsa.day1.array;

import java.util.ArrayList;
import java.util.List;

public class PowerSetByRecursion {
	public static void main(String[] args) {
		List<Integer> arr = List.of(3,1,2);
		printPowerSets(0, arr, new ArrayList<Integer>());
	}

	private static void printPowerSets(int index, List<Integer> arr, ArrayList<Integer> ans) {
		if(index >= arr.size()) {
			System.out.println(ans);
			return;
		}
		
		ans.add(arr.get(index));
		printPowerSets(index+1, arr, ans);
		ans.remove(ans.size()-1);
		printPowerSets(index+1, arr, ans);
	}
}
