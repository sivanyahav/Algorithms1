package MaxMax;

import java.util.Arrays;
import java.util.Stack;

public class maxMax5 {

	/**
	 * לכל איבר נצמיד מחסנית שתכיל את איברי המערך, בתחילה כל המחסניות ריקות.
	 * מכל זוג איברים במערך נשאיר את המקסימלי (מועמד למקס1) ואת השני נשים במחסנית השייכת לבן הזוג המקסימאלי שלו (מועמד למקס2)
	 * כלומר, במערך המצומצם נמצאים איברים שהם מועמדים למקס1 ובמחסניות נמצאים מועמדים למקס2.
	 * נעבור על המערך המצומצם ונתבונן בוגות האיברים הסמוכים - מכל זוג נבחר את האיבר המקסימלי ואת האיבר השני נכניס למחסנית של המקסימלי.
	 * נמשיך כך עד שנגיע לזוג אחרון שנשאר ממנו ניקח מקס 1 והשני ייכנס למחסנית שלו,
	 * מתוך המחסנית נבחר את מקס 2.
	 * Comparisons :  n-1+log2(n).
	 * @author Sivan
	 *
	 */

	static class Node {
		int number;
		Stack<Integer> stack;

		public Node(int num) {
			number = num;
			stack = new Stack<>();
		}
	}

	public static int[] maxMax(int[] arr) {

		Node[] nodes = new Node[arr.length];

		// copy and init
		for(int i = 0 ; i < nodes.length ; i++) {
			nodes[i] = new Node(arr[i]);
		}

		int index = maxMaxRec(nodes, 0 , nodes.length - 1);

		Node biggest = nodes[index];
		int max1 = biggest.number;
		int max2 = biggest.stack.pop();

		while(!biggest.stack.isEmpty()) {
			int temp_max2 = biggest.stack.pop();
			if(temp_max2 > max2)
				max2 = temp_max2;
		}

		return new int[] {max1, max2};
	}


	private static int maxMaxRec(Node[] nodes, int low, int high) {

		if(low < high) {

			int middle = (high + low)/2;
			int i = maxMaxRec(nodes,low, middle);
			int j = maxMaxRec(nodes, middle + 1 , high);

			int index;
			if(nodes[i].number > nodes[j].number) {
				nodes[i].stack.push(nodes[j].number);
				index = i;
			}
			else{ // nodes[i].number <= nodes[j].number

				nodes[j].stack.push(nodes[i].number);
				index = j;
			}

			return index;
		}
		else {
			return  low;
		}
	}

	public static void main(String[] args) {
		int[] arr = {84, 31, 3, 1, 567, 4, 2, 93202, 32, 3};
		System.out.println(Arrays.toString(maxMax(arr)));
		arr = new int[] {1,2,3,4,5,8,5,3,2,1,6,7,8};
		System.out.println(Arrays.toString(maxMax(arr)));
		arr = new int[] {-1,1,-2,2,-10,10,-100,100,30,2};
		System.out.println(Arrays.toString(maxMax(arr)));
	}
}
