package NumbersGame;

import java.util.Arrays;

public class EvenOrOdd {

	public static String chooseEvenOrOdd(int[] arr) {
		int odd_sum = 0 , even_sum = 0;

		for(int i = 0 ; i < arr.length; i++) {
			if(i%2==0)
				even_sum += arr[i];
			else
				odd_sum += arr[i];
		}

		if(even_sum > odd_sum)
			return "even";
		else
			return "odd";
	}

	public static int[] game(int[] arr) {
		int player1 = 0, player2 = 0, games = 0;
		int left_corner = 0, right_corner = arr.length-1;
		String strategy = chooseEvenOrOdd(arr);

		while (games != arr.length) {

			if(strategy.equals("even")) {

				if(games % 2 == 0) { // Player1 turn

					if (left_corner % 2 == 0) {
						player1 += arr[left_corner];
						left_corner++;
					} else {
						player1 += arr[right_corner];
						right_corner--;
					}

				}
				else { // Player2 turn

					if(arr[left_corner] > arr[right_corner]) {
						player2 += arr[left_corner];
						left_corner++;
					} else {
						player2 += arr[right_corner];
						right_corner--;
					}
				}

			} else { // odd

				if(games % 2 == 0) { // Player1 turn

					if(left_corner % 2 == 1) {
						player1 += arr[left_corner];
						left_corner++;
					} else {
						player1 += arr[right_corner];
						right_corner--;
					}
				} else { // Player2 turn

					if(arr[left_corner] > arr[right_corner]) {
						player2 += arr[left_corner];
						left_corner++;
					} else {
						player2 += arr[right_corner];
						right_corner--;
					}
				}
			}
			games++;
		}

		return new int[] {player1,player2};
	}

	public static void main(String[] args) {
		int[] arr = {1,3,6,1,3,6};
		System.out.println(Arrays.toString(game(arr)));
	}
}
