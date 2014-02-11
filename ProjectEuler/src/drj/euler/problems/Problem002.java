package drj.euler.problems;

import drj.euler.Utility;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 * 
 * 		1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not
 * exceed four million, find the sum of the even-valued terms.
 */
public class Problem002 {

	public static void main(String[] args) {
		Utility.Timer t = new Utility.Timer();
		t.start();

		int first = 1;
		int second = 2;
		int sumOfEven = 0;

		while (second < 4000000) {
			if (second % 2 == 0) {
				sumOfEven += second;
			}
			second = first + second;
			first = second - first;
		}

		System.out.println(sumOfEven);
		System.out.println(t.toDecimalString());
	}
}