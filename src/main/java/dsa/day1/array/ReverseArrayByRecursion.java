package dsa.day1.array;

public class ReverseArrayByRecursion {
	public static void main(String[] args) {
		int[] arr = new int[] {4, 5, 7, 9, 11, 12, 15, 17, 19};
		reverse(arr, 0);
		System.out.print("reversed array = ");
		
		for(int i: arr)
			System.out.print(i + " ");
	}

	private static void reverse(int[] arr, int i) {
		int n = arr.length;
		if(i>=n/2)
			return;
		
		swap(arr, i, n-i-1);
		reverse(arr, i+1);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
