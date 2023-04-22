package rough;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {
	public static void main(String[] args) {
		String romanNumeralInput = "III";
		System.out.println(
				String.format("%s in numeric is %d", 
						romanNumeralInput, romanToInt(romanNumeralInput)));
	}
	
	private static final Map<Character, Integer> romanNumerals = new LinkedHashMap<>();

	static {
		romanNumerals.put('I', 1);
		romanNumerals.put('V', 5);
		romanNumerals.put('X', 10);
		romanNumerals.put('L', 50);
		romanNumerals.put('C', 100);
		romanNumerals.put('D', 500);
		romanNumerals.put('M', 1000);
	}
	
	private static int romanToInt(String s) {
		int total = 0;
		for(int i=0; i<s.length(); i++) {
			if(i+1 < s.length()) {
				char current = s.charAt(i), next = s.charAt(i+1);
				if(romanNumerals.get(current) >= romanNumerals.get(next))
					total += romanNumerals.get(current);
				else
					total -= romanNumerals.get(current);
			} else
				total += romanNumerals.get(s.charAt(i));
		}
		return total;
	}
}
