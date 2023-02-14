package dsa.day1.array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		String input = "badrri";
		
		List<String> permutations = getPermutations(input);
		
		System.out.println(permutations);
	}

	private static List<String> getPermutations(String input) {
		List<String> result = new ArrayList<>();
		
		generatePermutations(input, result, "");
		return result;
	}

	private static void generatePermutations(String input, List<String> result, String ans) {
		if(input.length() == 0) {
			if(!result.contains(ans))
				result.add(ans);
			return;
		}
		
		for(int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);
			
			String restOfString = input.substring(0, i) + input.substring(i+1);
			
			generatePermutations(restOfString, result, ans + ch);
		}
	}
}
