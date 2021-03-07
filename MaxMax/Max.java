package MaxMax;

public class Max {
	
	/**
	 * ������ �� �� ����� ����� ������� ������ ������,
	 * ��"� �������� ������ ���
	 * O(n): n-1 comparisons
	 * @param arr
	 * @return
	 */
	public static int find_max(int[] arr) {
		int max= arr[0];
		for(int i=1; i< arr.length; i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
	}

}
