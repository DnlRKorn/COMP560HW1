package maze;

public class Main {

	public static void main(String[] args) {
		CheeseMaze c = new CheeseMaze("smallcheese.txt");
		AStarCheeseSearch aStar = new AStarCheeseSearch(c);	

	}
}
