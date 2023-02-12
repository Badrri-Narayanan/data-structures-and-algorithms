package dsa.day1.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		int numberOfRows = 6;
		List<List<Integer>> result = getPascalsTriangle(numberOfRows);
		System.out.println(result);
	}

	private static List<List<Integer>> getPascalsTriangle(int numberOfRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(List.of(1));
		
		if(numberOfRows < 2)
			return result;
		
		result.add(List.of(1,1));
		
		if(numberOfRows < 3)
			return result;
		int i=2;
		
		while(i < numberOfRows) {
			List<Integer> pascalsTriangle = new ArrayList<>();
			List<Integer> lastInsertedRow = result.get(i-1);
			
			pascalsTriangle.add(lastInsertedRow.get(0));
			int j=0;
			while(j < lastInsertedRow.size()-1) {
				pascalsTriangle.add(lastInsertedRow.get(j) + lastInsertedRow.get(j+1));
				j++;
			}
			pascalsTriangle.add(lastInsertedRow.get(0));
			
			result.add(pascalsTriangle);
			i++;
		}
		
		return result;
	}
}
