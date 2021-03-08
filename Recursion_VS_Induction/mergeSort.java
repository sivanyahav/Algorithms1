package Recursion_VS_Induction;

public class mergeSort {

	public void mergeSort(int[] arr, int low, int high) {
		
		if(low<high-1) {
			// Find the middle point
            		int mid = (low+high)/2;
 
            		// Sort first and second halves
            		mergeSort(arr, low, mid);
            		mergeSort(arr, mid + 1, high);
 
            		// Merge the sorted halves
            		merge(arr[low,mid],arr[mid,high]);
		}
	}
}
