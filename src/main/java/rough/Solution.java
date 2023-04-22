package rough;

class Solution {
    public static void main(String args[]) {
    	int x = 121;
    	
    	System.out.println("Is Palindrome = " + isPalindrome(x));
    }

	private static boolean isPalindrome(int num) {
		if (num < 0) {
	        return false;
	    }
	    int temp = num;
	    
	    int reversedNum = 0;
	    while(temp > 0) {
	    	reversedNum = (temp % 10) + (reversedNum * 10);
	    	temp /= 10;
	    }
	    
	    return num == reversedNum;
	}
}
