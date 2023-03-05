package rough;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String args[]) {
//        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
    	int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        int lon = maxSubArray(arr);

        System.out.println("\nlargest sum = " + lon);
    }
    
    public static int maxSubArray(int[] nums) {
        int largestSum = nums[0], sum=0;
        int start = 0, stop = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(sum<0) {
                sum=0;
                start = i+1;
            }
            if(sum>largestSum) {
                largestSum = sum;
                stop = i;
            }
        }
        
        for(int i=start; i<=stop; i++) {
            System.out.print(nums[i] + " ");
        }
        return largestSum;
    }

}
