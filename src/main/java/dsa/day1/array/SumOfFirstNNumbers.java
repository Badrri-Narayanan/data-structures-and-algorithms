package dsa.day1.array;

public class SumOfFirstNNumbers {
	public static void main(String[] args) {
		int n=30;
		System.out.println(String.format("Sum of first %d numbers = %d", n, sum(n)));
	}

	private static int sum(int n) {
		if(n<=0)
			return 0;
		return n + sum(n-1);
	}
}
