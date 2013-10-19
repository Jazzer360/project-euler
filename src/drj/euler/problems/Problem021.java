package drj.euler.problems;

import java.util.HashSet;
import java.util.Set;

import drj.euler.Utility;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).
 * If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and
 * each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 
 * 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem021 {

	public static void main(String[] args) {
		Utility.Timer t = new Utility.Timer();
		t.start();

		Set<Integer> amicables = new HashSet<Integer>();

		for (int a = 2; a < 10000; a++) {
			if (!amicables.contains(a)) {
				int sumA = 0;
				for (int factor : Utility.getFactors(a)) {
					sumA += factor;
				}
				sumA -= a;
				if (sumA != a) {
					int b = sumA;
					int sumB = 0;
					for (int factor : Utility.getFactors(b)) {
						sumB += factor;
					}
					sumB -= b;
					if (a == sumB) {
						amicables.add(a);
						amicables.add(b);
					}
				}
			}
		}

		int amicablesSum = 0;
		for (int amicable : amicables) {
			amicablesSum += amicable;
		}

		System.out.println(amicablesSum);
		System.out.println(t.toDecimalString());
	}

}
