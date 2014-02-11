package drj.euler.problems;

import drj.euler.Utility;

/**
 * The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100:
 *  	2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 */
public class Problem035 {

	public static void main(String[] args) {
		Utility.Timer t = new Utility.Timer();
		t.start();

		int circularPrimeCount = 0;

		for (int i = 2; i < 1_000_000; i++) {
			if (isCircularPrime(i)) {
				circularPrimeCount++;
			}
		}
		System.out.println(circularPrimeCount);
		System.out.println(t.toDecimalString());
	}

	private static boolean isCircularPrime(int num) {
		if (!Utility.isPrime(num)) {
			return false;
		}

		String string = Integer.toString(num);

		for (int i = 1; i < string.length(); i++) {
			if (!Utility.isPrime(Integer.parseInt(rotateString(string, i)))) {
				return false;
			}
		}
		return true;
	}

	private static String rotateString(String string, int mag) {
		StringBuilder digits = new StringBuilder(string);

		digits.append(digits.substring(0, mag));
		digits.delete(0, mag);

		return digits.toString();
	}
}