package dsa.day1.array;

import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {
	public static void main(String[] args) {
		int input = 15432;
		int nextPermutation = getNextPermutation(input);
		
		System.out.println("Next permutation of " + input + " = " + nextPermutation);
	}

	private static int getNextPermutation(int input) {
		int index1 = -1, index2 = -1;
		List<Integer> digits = List.of((input + "").split("")).stream()
						.map(digit -> Integer.parseInt(digit)).collect(Collectors.toList());
		
		for(int i = digits.size()-2; i>=0; i--) {
			if(digits.get(i) < digits.get(i+1)) {
				index1 = i;
				break;
			}
		}
		
		if(index1 > 0) {
			for(int i = digits.size()-1; i>=0; i--) {
				if(digits.get(index1) < digits.get(i)) {
					index2 = i;
					break;
				}
			}
			
			swap(digits, index1, index2);
		}
		
		List<Integer> resultList = reverse(digits, index1);
		
		String digitConcat = "";
		
		for(int d: resultList) 
			digitConcat += d;
		
		int result = Integer.parseInt(digitConcat);
		
		return result;
	}

	private static List<Integer> reverse(List<Integer> digits, int index1) {
		List<Integer> subList = index1 > 0 ? digits.subList(index1+1, digits.size()): digits;
		
		for(int i=0; i<subList.size(); i++) {
			if(i < subList.size()/2) {
				swap(subList, i, subList.size()-i-1);
			}
		}
		
		if(index1 > 0) {
			for(int i=index1; i>=0; i--) {
				subList.add(0, digits.get(i));
			}
		}
		
		return subList;
	}

	private static void swap(List<Integer> digits, int index1, int index2) {
		int temp = digits.get(index1);
		digits.set(index1, digits.get(index2));
		digits.set(index2, temp);
	}
}
