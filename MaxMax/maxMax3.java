package MaxMax;

import java.util.Arrays;

public class maxMax3 {

	public static int[] maxMax(int [] a) {

		int max1=a[0];
		int max2=a[0];
		int count=0; 

		//max1>max2
		for (int i = 1; i < a.length; i++) {

			count++;
			if(a[i]>max2) {

				count++;
				if(a[i]>max1) {
					max2=max1;
					max1=a[i];
				}
				else {
					count++;
					max2=a[i];
				}
			}

		}
		return new int[] {max1, max2, count};
	}
	////average calculation
	private static int[] buildRandomArray() {

		int [] test= new int [100];
		for (int i = 0; i < test.length; i++) {
			int r=(int)(Math.random()*1000+1);
			if(contains(test,r)) {
				while (contains(test,r))
					r=(int)(Math.random()*1000+1);
			}
			test[i]=r;
		}
		return test;
	}

	private static boolean contains(int[]a, int r) {
		for (int i = 0; i < a.length; i++) {
			if(a[i]==r)
				return true;
		}
		return false;
	}

	public static double averageMaxMax (int times) {
		int countTimes=times;
		double ans=0;
		int size=0;
		while(countTimes>0) {
			int[] test= buildRandomArray();
			int[] arr=maxMax(test);
			int comp=arr[2];
			ans+=comp;
			size=test.length;
			countTimes--;
		}
		double avr=(double)(ans/times);
		return avr/size;
	}
	
	public static void main(String[] args) {
		int[] a= {1,2,3};
		System.out.println(averageMaxMax(10000));
		
		int[] arr = {84,31,3,1,567,4,2,93202,32,3};
		System.out.println(Arrays.toString(maxMax(arr)));
		arr = new int[] {1,2,3,4,5,8,5,3,2,1,6,7,8};
		System.out.println(Arrays.toString(maxMax(arr)));
		arr = new int[] {-1,1,-2,2,-10,10,-100,100,30,2};
		System.out.println(Arrays.toString(maxMax(arr)));
	}
}
