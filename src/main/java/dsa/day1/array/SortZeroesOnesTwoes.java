package dsa.day1.array;

public class SortZeroesOnesTwoes {
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		
		sortColors(nums);
		
		for(int n: nums) {
			System.out.print(n + " ");
		}
	}
	
	public static void sortColors(int[] nums) {
		// Dutch National Flag Algorithm
        int low = 0, mid = 0, high = nums.length-1;
        
        while(mid <= high) {
        	switch(nums[mid]) {
	        	case 0: {
	        		int temp = nums[low];
	        		nums[low] = nums[mid];
	        		nums[mid] = temp;
	        		low++;
	        		mid++;
	        		break;
	        	}
	        	case 1: {
	        		mid++;
	        		break;
	        	}
	        	case 2: {
	        		int temp = nums[mid];
	        		nums[mid] = nums[high];
	        		nums[high] = temp;
	        		high--;
	        		break;
	        	}
        	}
        }
    }
}
