package maze;

import cheese.CheeseMaze;


public class Main {

	public static void main(String[] args) {
		CheeseMaze c = new CheeseMaze("smallcheese.txt");
		BruteForceAStarCheeseSearch aStar = new BruteForceAStarCheeseSearch(c);
	}
}
