package rough;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,1,0,-1,0,-2,2,50,-3,4,3,90};
		int key = 7;
		Arrays.sort(arr);
		
		boolean isPresent = binarySearch(arr, 0, arr.length-1, key);
		
		System.out.println(String.format("%d is %s in %s", key, isPresent ? "present": "absent", Arrays.toString(arr)));
	}

	private static boolean binarySearch(int[] arr, int start, int end, int key) {
		boolean isPresent = false;
		int mid = (start+end)/2;
		
		while(start <= end) {
			if(arr[mid] == key) {
				isPresent = true;
				break;
			} else if(arr[mid] < mid) {
				start = mid+1;
			} else {
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		return isPresent;
	}
}
