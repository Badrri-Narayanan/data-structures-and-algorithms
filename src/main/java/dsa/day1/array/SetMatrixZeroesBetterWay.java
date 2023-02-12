package dsa.day1.array;

public class SetMatrixZeroesBetterWay {
	public static void main(String[] args) {
		SetMatrixZeroesBetterWay solution = new SetMatrixZeroesBetterWay();
//		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		printMatrix(matrix);
		solution.setZeroes(matrix);
		printMatrix(matrix);
	}

	public void setZeroes(int[][] matrix) {
		int numberOfRows = matrix.length, numberOfColumns = matrix[0].length;
		boolean doesZerothColumnContainsZero = false;
		
		for(int i=0; i<numberOfRows; i++) {
			if(matrix[i][0] == 0)
				doesZerothColumnContainsZero = true;
		
            for(int j=0; j<numberOfColumns; j++)
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
		}
		
		for(int i = numberOfRows-1; i>=0; i--) {
			for(int j = numberOfColumns-1; j>=1; j--)
				if(matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			if(doesZerothColumnContainsZero) {
				matrix[i][0] = 0;
			}
		}
    }

	private static void printMatrix(int[][] matrix) {
		System.out.println("Matrix = ");
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}
