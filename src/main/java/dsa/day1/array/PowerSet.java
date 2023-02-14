package dsa.day1.array;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {
	public static void main(String[] args) {
		String input = "abc";
		
		Set<String> powerSet = generatePowerSet(input);
		
		System.out.println(powerSet);
	}

	private static Set<String> generatePowerSet(String input) {
		Set<String> powerSet = new HashSet<>();
		
		for(int i=0; i<1 << input.length(); i++) {
			String subStr = "";
			for(int j=0; j<input.length(); j++) {
				if((i & 1 << j) != 0) {
					subStr += input.charAt(j);
				}
			}
			powerSet.add(subStr);
		}
		
		return powerSet;
	}
}
