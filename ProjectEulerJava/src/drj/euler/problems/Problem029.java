package drj.euler.problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import drj.euler.Answer;
import drj.euler.Problem;

/**
 * Consider all integer combinations of a^b for 2 <= a <= 5 and 2 <= b <= 5:
 * 
 * <p>	2^2=4, 2^3=8, 2^4=16, 2^5=32
 * <br>	3^2=9, 3^3=27, 3^4=81, 3^5=243
 * <br>	4^2=16, 4^3=64, 4^4=256, 4^5=1024
 * <br>	5^2=25, 5^3=125, 5^4=625, 5^5=3125
 * 
 * <p>If they are then placed in numerical order, with any repeats removed, we
 * get the following sequence of 15 distinct terms:
 * 
 * <p>	4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
 * 
 * <p>How many distinct terms are in the sequence generated by a^b for
 * 2 <= a <= 100 and 2 <= b <= 100?
 */
@Answer("9183")
public class Problem029 extends Problem {

	public static void main(String[] args) {
		Problem p = new Problem029();
		System.out.println(p);
	}

	@Override
	protected String onSolve() {
		Set<BigInteger> set = new HashSet<BigInteger>();

		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				set.add(BigInteger.valueOf(i).pow(j));
			}
		}

		return String.valueOf(set.size());
	}
}