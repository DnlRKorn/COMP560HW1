package maze;

import cheese.AStarCheeseSearch;
import cheese.CheeseMaze;

public class Main {

	public static void main(String[] args) {
		CheeseMaze c = new CheeseMaze("smallcheese.txt");
		AStarCheeseSearch aStar = new AStarCheeseSearch(c);	

	}
}
