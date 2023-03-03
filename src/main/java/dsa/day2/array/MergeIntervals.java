package dsa.day2.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] input = {{1,3},{2,6},{8,10},{15,18}};
//		int[][] input = {{1,4},{0,4}};
//		int[][] input = {{1,4},{0,1}};
//		int[][] input = {{1,4},{0,0}};
//		int[][] input = {{2,5},{0,1}};
//		int[][] input = {{1,4},{2,3}};
//		int[][] matrix = {{1,3},{15,18},{2,6},{8,10}};
		List<List<Integer>> intermList = convertToList(input);
		
		Collections.sort(intermList, (a,b) -> a.get(0) - b.get(0));
		
		List<List<Integer>> result = mergeInterval(intermList);
		int[] [] finalResult = getFinalResult(result);
		
		RotateMatrix.printMatrix(finalResult);
	}
	
	private static List<List<Integer>> mergeInterval(List<List<Integer>> intermList) {
		List<List<Integer>> result = new ArrayList<>();
		
		List<Integer> current = intermList.get(0);
		for(int i=1; i<intermList.size(); i++) {
			if(current.get(1) >= intermList.get(i).get(0)) {
				int secondPart = intermList.get(i).get(1) > current.get(1) 
							? intermList.get(i).get(1) : current.get(1);
				current.set(1, secondPart);
			} else {
				List<Integer> item = new ArrayList<>();
				item.add(current.get(0));
				item.add(current.get(1));
				
				result.add(item);
				
				if(i<intermList.size())
					current = intermList.get(i);
			}
		}
		result.add(current);
		
		return result;
	}

	private static List<List<Integer>> convertToList(int[][] matrix) {
		List<List<Integer>> intermList = new ArrayList<>();
		
		for(int[] arr: matrix) {
			List<Integer> el = new ArrayList<>();
			el.add(arr[0]);
			el.add(arr[1]);
			
			intermList.add(el);
		}
		
		return intermList;
	}

	private static int[][] getFinalResult(List<List<Integer>> result) {
		int[][] finalResult = new int[result.size()][2];
		int i=0;
		
		for(List<Integer> element: result) {
			finalResult[i][0] = element.get(0);
			finalResult[i][1] = element.get(1);
			i++;
		}
		
		return finalResult;
	}
}
