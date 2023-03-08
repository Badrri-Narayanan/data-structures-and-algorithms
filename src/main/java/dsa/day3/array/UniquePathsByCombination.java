package dsa.day3.array;

public class UniquePathsByCombination {
	public static void main(String[] args) {
		int m = 4, n  = 6;
		System.out.println(uniquePaths(m, n));
	}
	
	public static int uniquePaths(int m, int n) {
		double totalCombinations = m+n-2;
		double r = m<n ? m-1: n-1;
		
		double result = 1;
		
		for(double i=0, j=r; j>0; j--, i++) {
			result *= (totalCombinations-i)/j;
		}
		return (int) Math.round(result);
    }
}
