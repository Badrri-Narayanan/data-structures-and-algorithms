package dsa.day1.array;

public class Palindrome {
	public static void main(String[] args) {
		String input = "madam";
		
		checkIfPalindrome(input);
		checkIfPalindrome("hello");
	}

	private static void checkIfPalindrome(String input) {
		if(isPalindrome(input, 0))
			System.out.println("It's a Palindrome");
		else
			System.out.println("It's not a Palindrome");
	}

	private static boolean isPalindrome(String input, int i) {
		int n = input.length();
		
		if(i>=n/2)
			return true;
		
		if(input.charAt(i) != input.charAt(n-i-1))
			return false;
		
		return isPalindrome(input, i+1);
	}
}
