package drj.euler.problems;

import java.util.ArrayList;

import drj.euler.Utility;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 * 
 * 					   3
 * 					  7 4
 * 					 2 4 6
 * 					8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom in triangle.txt (right click and
 * 'Save Link/Target As...'), a 15K text file containing a triangle with
 * one-hundred rows.
 * 
 * NOTE: This is a much more difficult version of Problem 18. It is not
 * possible to try every route to solve this problem, as there are 2^99
 * altogether! If you could check one trillion (10^12) routes every second it
 * would take over twenty billion years to check them all. There is an
 * efficient algorithm to solve it. ;o)
 */
public class Problem067 {

	public static void main(String[] args) {
		Utility.Timer t = new Utility.Timer();
		t.start();

		String filePath = "external data/triangle.txt";
		ArrayList<String[]> pyramid = new ArrayList<String[]>();

		for (String line : Utility.getFileContents(filePath)) {
			pyramid.add(line.split(" "));
		}

		int[][] triangle = new int[pyramid.size()][];
		int index = 0;

		for (String[] strings : pyramid) {
			triangle[index] = new int[strings.length];
			for (int i = 0; i < strings.length; i++) {
				triangle[index][i] = Integer.parseInt(strings[i]);
			}
			index++;
		}


		for (int i = triangle.length - 1; i > 0; i--) {
			for (int j = 0; j < triangle[i].length - 1; j++) {
				if (triangle[i][j] > triangle[i][j+1]) {
					triangle[i-1][j] += triangle[i][j];
				} else {
					triangle[i-1][j] += triangle[i][j+1];
				}
			}
		}

		System.out.println(triangle[0][0]);
		System.out.println(t.toDecimalString());
	}
}
