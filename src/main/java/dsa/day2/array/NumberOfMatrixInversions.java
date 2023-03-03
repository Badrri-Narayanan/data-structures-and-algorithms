package dsa.day2.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfMatrixInversions {
	public static void main(String[] args) {
		long[] arr = {2, 5, 1, 3, 4};
		
		System.out.println("number of inversions = " + getInversions(arr, arr.length));
	}
	
	public static long getInversions(long arr[], int n) {
        Set<List<Long>> sets = new HashSet<>();

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                List<Long> s = new ArrayList<>();

                s.add(arr[i]);
                s.add(arr[j]);

                sets.add(s);
            }
        }

        long noOfInversion = 0;

        for(List<Long> s: sets) {
            if(s.get(0) > s.get(1)) {
                noOfInversion++;
            }
        }

        return noOfInversion;
    }
}
