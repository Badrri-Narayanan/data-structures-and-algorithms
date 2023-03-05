package dsa.day2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// not working
public class NumberOfInversions {
	public static void main(String[] args) {
		int[] arr = {2, 5, 1, 3, 4};
		
		System.out.println("Number of inversions = " + countInversionsThruMergeSort(arr, 0, arr.length-1));
		System.out.println(Arrays.toString(arr));
	}

	private static int countInversionsThruMergeSort(int[] arr, int low, int high) {
		if(low == high)
			return 0;
		
		int count = 0;
		
		int mid = (low+high)/2;
		
		count += countInversionsThruMergeSort(arr, low, mid);
		count += countInversionsThruMergeSort(arr, mid+1, high);
		count += merge(arr, low, mid, high);
		
		return count;
	}

	private static int merge(int[] arr, int low, int mid, int high) {
		if(low == high)
			return 0;
		
		List<Integer> temp = new ArrayList<>();
		
		int left = low;
		int right = mid+1;
		int count = 0;
		while(left <= mid && right <= high) {
			if(arr[left] > arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
				count += mid-left;
			}
		}
		
		while(left <= mid) {
			temp.add(arr[left]);
			left++;
		}
		
		while(right <= high) {
			temp.add(arr[right]);
			count++;
			right++;
		}
		
		for(int i=low; i<=high; i++) {
			arr[i] = temp.get(i-low);
		}
		
		return count;
	}
}
