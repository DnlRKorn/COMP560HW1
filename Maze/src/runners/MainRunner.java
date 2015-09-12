package runners;

import cheese.AStarCheeseSearch;
import cheese.CheeseMaze;
import maze.AStarSearch;
import maze.BreadthFirstSearch;
import maze.DepthFirstSearch;
import maze.GreedyBestFirstSearch;
import maze.Maze;
import maze.Search;

public class MainRunner {
	
	/**
	 * 
	 * @param args Enter name of maze file in command line arguments
	 */
	public static void main(String[] args) {
		Search search;
		Maze m;
		String algorithm = args[0];
//		if(algorithm.equalsIgnoreCase("cheese")){
//			m = new CheeseMaze(args[1]);
//			System.out.println("Start x = " + m.start.x);
//			System.out.println("Start y = " + m.start.y);
//			System.out.println("Goal x = " + m.goal.x);
//			System.out.println("Goal y = " + m.goal.y);
//			search = new AStarCheeseSearch(m, m.start, m.goal);
//		}
//		else{
		System.out.println(args[0]);
			m = new Maze(args[1]);
			System.out.println("Start x = " + m.start.x);
			System.out.println("Start y = " + m.start.y);
			System.out.println("Goal x = " + m.goal.x);
			System.out.println("Goal y = " + m.goal.y);
			if(algorithm.equalsIgnoreCase("BreadthFirst")){
				search = new BreadthFirstSearch(m, m.start, m.goal);
			}
			else if(algorithm.equalsIgnoreCase("DepthFirst")){
				search = new DepthFirstSearch(m, m.start, m.goal);
			}
			else if(algorithm.equalsIgnoreCase("GreedyBestFirst")){
				search = new GreedyBestFirstSearch(m, m.start, m.goal);
			}
			else{
				search = new AStarSearch(m, m.start, m.goal);
			}
//		}
			
		m.processSolution(search.getSolution());
	}
}
