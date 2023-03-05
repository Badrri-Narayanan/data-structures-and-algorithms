package rough;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {4,1,6,2,7};
		mergeSort(arr);
		printArray(arr, 0, arr.length-1);
	}

	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if(low >= high)
			return;
		
		int mid = (low+high)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		if(low == high)
			return;
		
		List<Integer> temp = new ArrayList<>();
		
		int left = low, right = mid+1;
		while(left <= mid && right <= high) {
			if(arr[left] < arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}
		
		while(left <= mid) {
			temp.add(arr[left]);
			left++;
		}
		
		while(right <= high) {
			temp.add(arr[right]);
			right++;
		}
		
		for(int i=low; i <= high; i++) {
			arr[i] = temp.get(i-low);
		}
	}

	private static void printArray(int[] arr, int low, int high) {
		for(int i=low; i<=high; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
