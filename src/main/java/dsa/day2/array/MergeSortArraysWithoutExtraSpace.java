package dsa.day2.array;

public class MergeSortArraysWithoutExtraSpace {
	public static void main(String[] args) {
//		int[] arr1 = {1,2,3,0,0,0};
//		int[] arr2 = {2,5,6};
		
		int[] arr1 = {2,0};
		int[] arr2 = {1};
		
		merge(arr1, 1, arr2, arr2.length);
		
		printArray(arr1);
	}
	
	private static void printArray(int[] arr) {
		for(int n: arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int j=0;
		if(n > 0) {
            for(int i=0; i<nums1.length && j<n; i++) {
                if(nums1[i] > nums2[j]) {
                    int k= nums1.length-1;
                    while(k>i) {
                        nums1[k] = nums1[k-1];
                        k--;
                    }
                    nums1[i] = nums2[j];
                    j++;
                }
            }

            while(j<n) {
                nums1[m+j] = nums2[j];
                j++;
            }
        }
    }
}
