package dsa.day1.array;

public class NumberOfSubsequenceWithSumK {
	public static void main(String[] args) {
		int[] arr = new int[] {4,2,1,3};
		int k=5;
		System.out.println("Number of subsequences with sum = " + k + " = " + countSubsequencesWithSumK(0, arr, k, 0));
	}

	private static int countSubsequencesWithSumK(int index, int[] arr, int k, int sum) {
		if(index == arr.length) {
			if(sum == k)
				return 1;
			else
				return 0;
		}
		
		sum += arr[index];
		// take
		int left = countSubsequencesWithSumK(index+1, arr, k, sum);
		
		// not take
		sum -= arr[index];
		int right = countSubsequencesWithSumK(index+1, arr, k, sum);
		
		return left + right;
	}
}
