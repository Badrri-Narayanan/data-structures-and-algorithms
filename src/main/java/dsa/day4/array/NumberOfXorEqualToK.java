package dsa.day4.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberOfXorEqualToK {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(3);
		arr.add(8);
		arr.add(3);
		arr.add(10);
		
		int x = 8;
		int count = subarraysXor(arr, x);
		
		System.out.println("count = " + count);
	}
	
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		int count = 0, xorr = 0;
		Map<Integer, Integer> hash = new HashMap<>();
		
		for(int i=0; i<arr.size(); i++) {
			xorr = xorr^arr.get(i);
			
			if(xorr == x)
				count++;
			
			if(hash.get(xorr ^ x) != null)
				count += hash.get(xorr ^ x);
			
			if(hash.get(xorr) !=null)
				hash.put(xorr, hash.get(xorr)+1);
			else
				hash.put(xorr, 1);
		}
		
		return count;
	}
}
