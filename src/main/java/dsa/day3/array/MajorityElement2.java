package dsa.day3.array;

import java.util.ArrayList;
import java.util.List;
// not working expected answer = [1]
public class MajorityElement2 {
	public static void main(String[] args) {
		int[] arr = {2,1,1,3,1,4,5,6};
		System.out.println("Major Element = " + majorityElement(arr));
	}
	
	public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0, element1 = Integer.MIN_VALUE, count2 = 0, element2 = Integer.MIN_VALUE;
        List<Integer> majorElements = new ArrayList<>();
		
		for(int n: nums) {
			if(count1 == 0)
				element1 = n;
            else if(count2 == 0)
                element2 = n;
			
			if(element1 == n) {
				count1++;
            } else if(element2 == n) {
                count2++;
            } else {
				count1--;
                count2--;
            }
		}

        count1 = 0;
        count2 = 0;
        for(int n: nums) {
            if(element1 == n)
                count1++;
            if(element2 == n)
                count2++;
        }
        
        System.out.println("el1 = " + element1);
        System.out.println("el2 = " + element2);
        if(count1 > nums.length/3)
            majorElements.add(element1);
        
        if(count2 > nums.length/3 && element1 != element2)
            majorElements.add(element2);
		
		return majorElements;
    }
}
