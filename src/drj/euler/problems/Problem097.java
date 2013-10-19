package drj.euler.problems;

import drj.euler.Utility;

/**
 * The first known prime found to exceed one million digits was discovered in
 * 1999, and is a Mersenne prime of the form 2^6972593 - 1; it contains exactly
 * 2,098,960 digits. Subsequently other Mersenne primes, of the form 2^p - 1,
 * have been found which contain more digits.
 * 
 * However, in 2004 there was found a massive non-Mersenne prime which contains
 * 2,357,207 digits: 28433 x 2^7830457 + 1.
 * 
 * Find the last ten digits of this prime number.
 */
public class Problem097 {

	public static void main(String[] args) {
		Utility.Timer t = new Utility.Timer();
		t.start();

		long n = 28_433;
		for (int i = 0; i < 7_830_457; i++) {
			n *= 2;
			n %= 10_000_000_000L;
		}
		n++;

		System.out.println(n);
		System.out.println(t.toDecimalString());
	}
}
