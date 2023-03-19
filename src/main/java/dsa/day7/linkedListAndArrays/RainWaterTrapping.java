package dsa.day7.linkedListAndArrays;

public class RainWaterTrapping {
	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println("Amount of water trapped = " + trap(nums));
	}
	
	public static int trap(int[] height) {
		int trapped = 0, max = Integer.MIN_VALUE;
		
		int[] prefix = new int[height.length], suffix = new int[height.length];
		
		for(int i=0; i<height.length; i++) {
			if(max < height[i])
				max=height[i];
			prefix[i] = max;
		}
		
		max = Integer.MIN_VALUE;
		
		for(int i=height.length-1; i>=0; i--) {
			if(max < height[i])
				max = height[i];
			suffix[i] = max;
		}
		
		for(int i=0; i<height.length; i++) {
			trapped += Integer.min(prefix[i], suffix[i]) - height[i];
		}
		
		return trapped;
    }
}
