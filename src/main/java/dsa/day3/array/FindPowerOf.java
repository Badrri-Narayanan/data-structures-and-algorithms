package dsa.day3.array;

public class FindPowerOf {
	public static void main(String[] args) {
		double number = 2;
		int n = -2147483648;
		System.out.println(myPow(number, n));
	}
	
	public static double myPow(double x, int n) {
        if(x == 1 || n==0) {
            return 1;
        }
        
        double answer = 1;
        int dup = n;
        
        if(dup < 0) {
        	dup *= -1;
        }
        
        if(x == -1)
        	if(n%2==0)
        		return 1;
        	else
        		return -1;
        
        if(n == Integer.MIN_VALUE) 
        	return 0;
        
        while(dup > 0) {
        	if(dup % 2 == 0) {
        		x = x*x;
        		dup/=2;
        	} else {
        		answer *= x;
        		dup -= 1;
        	}
        }
        
        if(n < 0)
        	return 1/answer;
        
        return answer;
    }
}
