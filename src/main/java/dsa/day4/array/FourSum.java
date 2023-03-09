package dsa.day4.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FourSum {
	public static void main(String[] args) {
//		int[] nums = {1000000000,1000000000,1000000000,1000000000};
//		int target = -294967296;
		
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		
//		int[] nums = {0,0,0,0,0};
//		int target = 0;
		

//		int[] nums = {-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
//		int target = 294967296;
		
		mergeSort(nums, 0, nums.length-1);
		List<List<Integer>> results = fourSum(nums, target);

		for(List<Integer> ans: results) {
			System.out.println(ans);
		}
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> results = new HashSet<>();
        
        if((target < 0 && !isAllElementsPositive(nums)) 
        		|| (target >= 0 && !isAllElementsNegative(nums)) || target == 0) {
	        for(int i=0; i<nums.length; i++) {
	        	for(int j=i+1; j<nums.length; j++) {
	        		for(int k=j+1; k<nums.length; k++) {
	        			int key = target - (nums[i]+nums[j]+nums[k]);
	        			if(binarySearch(nums, k+1, nums.length-1, key)) {
	        				List<Integer> ans = new ArrayList<>();
	        				ans.add(nums[i]);
	        				ans.add(nums[j]);
	        				ans.add(nums[k]);
	        				ans.add(key);
	        				
	        				if(target <= 0 || (target >= 0 && ans.stream().filter(n -> n > 0).collect(Collectors.toList()).size() > 0))
	        					results.add(ans);
	        			}
	        		}
	        	}
	        }
        }
        
        return results.stream().toList();
    }
	
	private static boolean isAllElementsNegative(int[] nums) {
		boolean isAllNegative = true;
		
		for(int n: nums) {
			if(n > 0) {
				isAllNegative = false;
				break;
			}
		}
		return isAllNegative;
	}

	private static boolean isAllElementsPositive(int[] nums) {
		boolean isAllPositive = true;
		
		for(int n: nums) {
			if(n < 0) {
				isAllPositive = false;
				break;
			}
		}
		return isAllPositive;
	}

	private static boolean binarySearch(int[] nums, int start, int end, int key) {
		boolean isPresent = false;
		
		int mid = (start+end)/2;
		
		while(start <= end) {
			if(nums[mid] == key) {
				isPresent = true;
				break;
			} else if(nums[mid] < key) {
				start = mid+1;
			} else {
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		
		return isPresent;
	}

	private static void mergeSort(int[] nums, int low, int high) {
		if(low >= high)
			return;
		
		int mid = (low+high)/2;
		mergeSort(nums, low, mid);
		mergeSort(nums, mid+1, high);
		merge(nums, low, mid, high);
	}

	private static void merge(int[] nums, int low, int mid, int high) {
		if(low >= high)
			return;
		
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
			nums[i] = temp.get(i - low);
		}
	}
}
