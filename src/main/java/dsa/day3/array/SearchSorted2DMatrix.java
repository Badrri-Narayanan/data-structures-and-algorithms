package dsa.day3.array;

public class SearchSorted2DMatrix {
	public static void main(String[] args) {
		int[][] sortedMatrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
		System.out.println(target + " found? " + searchMatrix(sortedMatrix, target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        
        int possibleRow = -1;
        
        for(int i=0; i<matrix.length;) {
            if(matrix[i][0] == target || matrix[i][matrix[i].length-1] == target) {
                found = true;
                break;
            } else if(matrix[i][0] < target && matrix[i][matrix[i].length-1] > target) {
                possibleRow = i;
                break;
            } else {
                i++;
            }
        }
        
        if(possibleRow >= 0) {
            for(int j=1; j<matrix[possibleRow].length-1; j++) {
                if(matrix[possibleRow][j] == target) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }
}
