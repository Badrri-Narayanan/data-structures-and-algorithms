package dsa.day3.array;

import java.util.ArrayList;
import java.util.List;

public class FindNumberOfReversedPairs {
	public static void main(String[] args) {
//		int[] nums = {1,3,2,3,1};
//		int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647};
//		int[] nums = {-5, -5};
		int[] nums = {233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004};
		System.out.println("Number of reversed pairs = " + reversePairs(nums));
	}
	
	public static int reversePairs(int[] nums) {
		if(nums.length == 1)
			return 0;
		
		int el = nums[0];
		boolean isAllElementSameAndPositive = true;
        
		for(int i=1; i<nums.length; i++) {
			if(el != nums[i] || nums[i] < 0 || el < 0) {
				isAllElementSameAndPositive = false;
				break;
			}
		}
		
		if(isAllElementSameAndPositive)
			return 0;
		
		int count = mergeSort(nums, 0, nums.length-1);
		return count;
    }

	private static int mergeSort(int[] nums, int low, int high) {
		if(low >= high)
			return 0;
		
		int mid = (low+high)/2;
		
		int count = mergeSort(nums, low, mid);
		count += mergeSort(nums, mid+1, high);
		count += merge(nums, low, mid, high);
		return count;
	}

	private static int merge(int[] nums, int low, int mid, int high) {
		if(low >= high)
			return 0;
		
		int count = 0;
		int j=mid+1;
		for(int i=low; i<=mid; i++) {
			while(j<=high && nums[i] > (2* nums[j])) {
				j++;
			}
			count += (j - (mid+1));
		}
		int left = low, right = mid+1;
		List<Integer> temp = new ArrayList<>();
		
		while(left <= mid && right <= high) {
			if(nums[left] < nums[right]) {
				temp.add(nums[left]);
				left++;
			} else {
				temp.add(nums[right]);
				right++;
			}
		}
		
		while(left <= mid) {
			temp.add(nums[left]);
			left++;
		}
		
		while(right <= high) {
			temp.add(nums[right]);
			right++;
		}
		
		for(int i=low; i<=high; i++) {
			nums[i] = temp.get(i-low);
		}
		
		return count;
	}
	
}
