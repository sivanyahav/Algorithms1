package MinMax;

import java.util.Arrays;

public class minMax1 {

	/*
	 * Comparisons : n - 1
	 */
	public static int getMax(int[] arr) {
		int ans = arr[0];

		for(int i = 1 ; i < arr.length ; i++) {
			if(ans < arr[i])
				ans  = arr[i];
		}

		return ans;
	}

	/*
	 * Comparisons : n - 1
	 */
	public static int getMin(int[] arr) {
		int ans = arr[0];

		for(int i = 1 ; i < arr.length ; i++) {
			if( ans > arr[i])
				ans = arr[i];
		}

		return ans;
	}

	/*
	 * Comparisons : 2n - 2
	 */
	public static int[] min_max(int arr[]) {
		int max= getMax(arr);
		int min= getMin(arr);
		return new int[] { max, min };
	}

	public static void main(String[] args) {
		int[] arr = {84,31,3,1,567,4,2,93202,32,3};
		System.out.println(Arrays.toString(min_max(arr)));

		arr = new int[] {1,2,3,4,5,8,5,3,2,1,6,7,8};
		System.out.println(Arrays.toString(min_max(arr)));

		arr = new int[] {-1,1,-2,2,-10,10,-100,100,30,2};
		System.out.println(Arrays.toString(min_max(arr)));
	}

}
