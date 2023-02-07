package dsa.day1.array;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		SetMatrixZeroes solution = new SetMatrixZeroes();
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		solution.setZeroes(matrix);
	}
	
	public void setZeroes(int[][] matrix) {
		List<String> locationOfZeroes = new ArrayList<String>();
		
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[i].length; j++)
                if(matrix[i][j] == 0)
                    locationOfZeroes.add(i + "," + j);
        
        for(String loc: locationOfZeroes) {
        	String[] index = loc.split(",");
        	setRowAndColumnAsZeroes(matrix, Integer.parseInt(index[0]), Integer.parseInt(index[1]));
        }
        System.out.println(matrix);
    }

	private void setRowAndColumnAsZeroes(int[][] matrix, int row, int column) {
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[i].length; j++)
				if(i==row || j== column)
					matrix[i][j] = 0;
	}

}
