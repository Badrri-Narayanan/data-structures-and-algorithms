package dsa.day2.array;

public class RotateMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		
		rotate(matrix);
		
		printMatrix(matrix);
	}

	private static void rotate(int[][] matrix) {
		int n = matrix.length;
		
		// transpose
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// reversing each row
		for(int i=0; i<n; i++) {
			for(int j=0; j<n/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
	}

	// brute force
	public static int[][] bruteForceRotate(int[][] matrix) {
		int n = matrix.length;
		int[][] rotatedMatrix = new int[n][n];
		
		for(int i=0; i<n; i++) {
			int k = n - 1;
			for(int j=0; j<n; j++, k--) {
				rotatedMatrix[i][j] = matrix[k][i];
			}
		}
		return rotatedMatrix;
	}

	public static void printMatrix(int[][] matrix) {
		for(int[] row: matrix) {
			for(int col: row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}

}
