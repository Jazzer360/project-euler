package drj.euler.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import drj.euler.Utility;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a
 * name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938  53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 */
public class Problem022 {

	public static void main(String[] args) {
		Utility.Timer t = new Utility.Timer();
		t.start();

		String filePath = "external data/names.txt";
		List<String> names = new ArrayList<String>();

		for (String line : Utility.getFileContents(filePath)) {
			for (String name : line.split(",")) {
				names.add(name.replace("\"", ""));
			}
		}
		Collections.sort(names);

		int scoreSum = 0;

		for (int i = 0; i < names.size(); i++) {
			int score = 0;

			for (char letter : names.get(i).toCharArray()) {
				score += (int) letter - 64;
			}

			score *= i + 1;
			scoreSum += score;
		}

		System.out.println(scoreSum);
		System.out.println(t.toDecimalString());
	}
}