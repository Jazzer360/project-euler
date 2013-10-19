package drj.euler.problems;

import drj.euler.Utility;

/**
 * It is possible to write five as a sum in exactly six different ways:
 * 
 * 		4 + 1
 * 		3 + 2
 * 		3 + 1 + 1
 * 		2 + 2 + 1
 * 		2 + 1 + 1 + 1
 * 		1 + 1 + 1 + 1 + 1
 * 
 * How many different ways can one hundred be written as a sum of at least two
 * positive integers?
 */
public class Problem076 {
	
	public static void main(String[] args) {
		Utility.Timer t = new Utility.Timer();
		t.start();

		int[] nums = new int[99];
		for (int i = 0; i < 99; i++) {
			nums[i] = i + 1;
		}
		int target = 100;

		System.out.println(combinations(nums, target));
		System.out.println(t.toDecimalString());
	}

	private static int combinations(int[] nums, int target) {
		return recurseWays(nums, target, nums.length);
	}

	private static int recurseWays(int[] nums, int target, int numIndex) {
		if (target == 0) {
			return 1;
		}
		if (target < 0 || numIndex == 0) {
			return 0;
		}
		int combosCurrentIndex =
				recurseWays(nums, target - nums[numIndex - 1], numIndex);
		int combosNextIndex =
				recurseWays(nums, target, numIndex - 1);
		return combosCurrentIndex + combosNextIndex;
	}
}
