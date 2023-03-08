package dsa.day3.array;

public class UniquePathsDynamicProgramming {
	public static void main(String[] args) {
		int m = 19, n  = 13;
		System.out.println(uniquePaths(m, n));
	}
	
	public static int uniquePaths(int m, int n) {
		int[][] hash = new int[m][n];
		
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				hash[i][j] = -1;
		
		return findUniquePaths(m, n, 0, 0, hash);
    }

	private static int findUniquePaths(int m, int n, int i, int j, int[][] hash) {
		if(i>=m || j>=n)
			return 0;
		
		if(i == m-1 || j == n-1)
			return 1;
		
		if(hash[i][j] != -1)
			return hash[i][j];
		
		int left = findUniquePaths(m, n, i+1, j, hash);
		int right = findUniquePaths(m, n, i, j+1, hash);
		
		hash[i][j] = left+right;
		
		return left+right;
	}
}
