package dsa.day1.array;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public static void main(String[] args) {
		List<List<String>> solution = solveNQueens(4);
		
		System.out.println(solution);
	}

	private static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				board[i][j] = '.';
		
		List<List<String>> results = new ArrayList<>();
		
		int[] straight = new int[n];
		int[] leftCross = new int[(2 * n) - 1];
		int[] rightCross = new int[(2 * n) - 1];
		
		generateNQueens(0, board, results, straight, leftCross, rightCross);
		return results;
	}

	private static void generateNQueens(int row, char[][] board, List<List<String>> results, int[] straight, int[] leftCross, int[] rightCross) {
		if(row == board.length) {
			List<String> solution = new ArrayList<>();
			for(int p=0; p<board.length; p++) {
				String line = "";
				
				for(int q=0; q<board.length; q++)
					line += board[p][q];
				
				solution.add(line);
			}
			results.add(solution);
			return;
		}
		
		for(int i=0; i<board.length; i++) {
			if(straight[i] == 0 && leftCross[row+i] == 0 && rightCross[board.length-1+i-row] == 0) {
				board[row][i] = 'Q';
				
				straight[i] = 1;
				leftCross[row+i] = 1;
				rightCross[board.length-1+i-row] = 1;
				
				generateNQueens(row+1, board, results, straight, leftCross, rightCross);
				
				board[row][i] = '.';
				
				straight[i] = 0;
				leftCross[row+i] = 0;
				rightCross[board.length-1+i-row] = 0;
			}
		}
	}

}
