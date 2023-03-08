package dsa.day3.array;

public class UniquePaths {
	public static void main(String[] args) {
		int m = 3, n  = 2;
		System.out.println(uniquePaths(m, n));
	}
	
	public static int uniquePaths(int m, int n) {
		return findUniquePaths(m, n, 0, 0);
    }

	private static int findUniquePaths(int m, int n, int i, int j) {
		if(i >= m || j >= n)
			return 0;
		
		if(i == m-1 && j==n-1)
			return 1;
		
		int left = findUniquePaths(m, n, i+1, j);
		int right = findUniquePaths(m, n, i, j+1);
		return left + right;
	}
}
