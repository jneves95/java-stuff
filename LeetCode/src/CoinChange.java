import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * LeetCode 11 March 2021 Challenge
 * 
 * Given an array of possible coin values, and a monetary amount,
 * returns the minimum number of coins given out in change for that amount,
 * or -1 if it isn't possible
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		
		// Reverse order
		for (int i = 0, j = coins.length - 1; i < j; i++, j--) {
			int temp = coins[i];
			coins[i] = coins[j];
			coins[j] = temp;
		}
		
		// Initialize counters
		int i = 0;
		int count = 0;
		int sum = 0;
		int[] coinCount = new int[coins.length];
		int minCount = -1;
		
		// Main loop
		while (i >= 0 && i < coins.length) {
			if (sum == amount) {
				if (minCount < 0) minCount = count;
				else minCount = Math.min(minCount, count);
				sum += coins[i];
				coinCount[i]++;
				count++;
			}
			if (sum < amount) {
				coinCount[i]++;
				sum += coins[i];
				count++;
			}
			else if (sum > amount) {
				// Decrement coin of this value and, if possible, increment smaller coin of largest value
				if (i < coins.length - 1) {
					sum -= coins[i];
					coinCount[i]--;
					i++;
					sum += coins[i];
					coinCount[i]++; 
				}
				else {
					// If there are no coins of smaller value, zero this coin and decrement smallest coin of bigger value
					sum -= coins[i] * coinCount[i];
					count -= coinCount[i];
					coinCount[i] = 0;
					i--;
					
					while (i >= 0) {
						if (coinCount[i] > 0) {
							sum -= coins[i];
							coinCount[i]--;
							count--;
							i++;
							break;
						}
						i--;
					}
				}
			}
		}
		
		return minCount;
	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		
		System.out.println(cc.coinChange(new int[]{186, 419, 83, 408}, 6249));
	}

}


/*
 * 
 * 
 * 75, [20, 10, 2]
 * 
 * 20
 * 20 20
 * 20 20 20
 * 20 20 20 20 X
 * 20 20 20 10
 * 20 20 20 10 10 X
 * 20 20 20 10 2
 * 20 20 20 10 2 2
 * 20 20 20 10 2 2 2 X
 * 20 20 20 10 2 2 
 * 
 * 
 * 20: 0
 * 10: 0
 * 2:  38
 * 
 * 
 * 74 - [23, 18, 15]
 * 
 * 23: 2
 * 18: 1
 * 15: 1
 * 
 * 23 23 23 23 = 92	[4, 0, 0]
 * 23 23 23 18 = 87	[3, 1, 0]
 * 23 23 23 15 = 84	[3, 0, 1]
 * 23 23 18 18 = 82 [2, 2, 0]
 * 23 23 18 15 = 79	[2, 1, 1]
 * 23 23 15 15 = 76
 * 23 18 18 18 = 77 [1, 3, 0]
 * 23 18 18 15 = 74 <---
 * 
 * 4, 0, 0
 * 3, 1, 0
 * 3, 0, 1
 * 2, 2, 0
 * 2, 1, 1
 * 2, 0, 2
 * 1, 3, 0
 * 1, 2, 1
 * 1, 1, 2
 * 1, 0, 3
 * 0, 5, 0
 * 0, 4, 1
 * 0, 3, 2
 * 0, 2, 3
 * 0, 1, 4
 * 0, 0, 5
 * 
 * 
 * 83 [57, 23, 9, 5, 3]
 * 
 * 25 25 25 25 = 100
 * 25 25 25 10 = 85
 * 25 25 25 5 5 = 85
 * 25 25 25 5 2 = 82
 * 25 25 25 5 2 2 = 84
 * 25 25 25 5 2 1 = 83
 * 
 * 
 * 57 57 = 114
 * 57 23 = 80
 * 57 23 23 = 1053
 * 57 23 9 = 89
 * 57 23 5 = 85
 * 57 23 3 = 83 <---
 * 57 9 = 66
 * 57 9 9 = 75
 * 57 9 9 9 = 84
 * 57 9 9 5 = 80
 * 57 9 9 5 5 = 85
 * 57 9 9 5 3 = 83 <---
 * 
 * 57 23 9 5 3
 * 1 0 0 0 0
 * 2 0 0 0 0
 * 1 1 0 0 0
 * 1 2 0 0 0
 * 1 1 1 0 0
 * 1 1 0 1 0
 * 1 1 0 0 1
 * 1 0 1 0 0
 * 1 0 2 0 0
 * 1 0 3 0 0
 * 1 0 2 1 0
 * 1 0 2 2 0
 * 1 0 2 1 1 <---
 * 
 */
