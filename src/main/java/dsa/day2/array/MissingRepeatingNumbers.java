package dsa.day2.array;

public class MissingRepeatingNumbers {
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 5, 3};
		
		int[] result = getMissingAndRepeatingNumber(arr);
		
		System.out.println("Missing Number = "+result[0]+". Repeating Number = "+result[1]);
	}

	private static int[] getMissingAndRepeatingNumber(int[] arr) {
		long arraySum = 0, arraySumOfSquares = 0;
		
		for(int n: arr) {
			arraySum += n;
			arraySumOfSquares += (n*n);
		}
		int size = arr.length;
		long originalSum = (size * (size +1)) /2;
		long originalSumOfSquares = ((size)*(size+1)*((2*size) +1))/6;
		
		int[] result = new int[2];

		long sumDiff = originalSum - arraySum, sumOfSquareDiff = originalSumOfSquares - arraySumOfSquares;
		
		result[0] = (int) ((sumOfSquareDiff + (sumDiff * sumDiff))/(2*sumDiff));
		result[1] = (int) ((sumOfSquareDiff - (sumDiff * sumDiff))/(2*sumDiff));
		return result;
	}
}
