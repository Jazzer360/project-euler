package drj.euler.problems;

import drj.euler.Utility;


/**
 * Triangle, pentagonal, and hexagonal numbers are generated by the following
 * formulae:
 * 
 * 		Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
 * 		Pentagonal	 	Pn=n(3n-1)/2	1, 5, 12, 22, 35, ...
 * 		Hexagonal	 	Hn=n(2n-1)	 	1, 6, 15, 28, 45, ...
 * 
 * It can be verified that T285 = P165 = H143 = 40755.
 * 
 * Find the next triangle number that is also pentagonal and hexagonal.
 */
public class Problem045 {

	public static void main(String[] args) {
		Utility.Timer t = new Utility.Timer();
		t.start();

		long triangle = 1;
		boolean answerFound = false;

		for (int i = 286; !answerFound; i++) {
			triangle = Utility.getTriangleNumber(i);
			if (Utility.isPentagonal(triangle)
					&& Utility.isHexagonal(triangle)) {
				answerFound = true;
			}
		}

		System.out.println(triangle);
		System.out.println(t.toDecimalString());
	}
}
