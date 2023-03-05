package dsa.day3.array;

public class MajorityElementByMooreVotingAlgorithm {
	public static void main(String[] args) {
		int[] arr = {2,2,1,1,1,2,2};
		System.out.println("Major Element = " + mooresVotingAlogrithm(arr));
	}

	private static int mooresVotingAlogrithm(int[] arr) {
		int count = 0, element = 0;
		
		for(int n: arr) {
			if(count == 0)
				element = n;
			
			if(n == element)
				count++;
			else
				count--;
		}
		
		return element;
	}
}
