package dsa.day1.array;

import java.util.HashSet;
import java.util.Set;

public class ContinousPowerSets {
	public static void main(String[] args) {
		String input = "badrri";
		Set<String> continuousSubSets = generateContinuousSubSets(input);
		
		System.out.println(continuousSubSets);
	}

	private static Set<String> generateContinuousSubSets(String input) {
		Set<String> continuousSubSets = new HashSet<>();
		
		for(int i=0; i < 1 << input.length(); i++) {
			String subSet = "";
			for(int j=0; j < input.length(); j++) {
				if((i & 1 << j) != 0) {
					subSet += input.charAt(j);
				}
			}
			if(input.contains(subSet) && subSet.length() == 3) {
				continuousSubSets.add(subSet);
			}
		}
		
		return continuousSubSets;
	}
}
