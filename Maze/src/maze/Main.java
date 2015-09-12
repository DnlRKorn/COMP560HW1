package maze;

public class Main {

	public static void main(String[] args) {
		CheeseMaze c = new CheeseMaze("smallcheese.txt");
		AStarCheeseASearch2 aStar = new AStarCheeseASearch2(c);	

	}
}
