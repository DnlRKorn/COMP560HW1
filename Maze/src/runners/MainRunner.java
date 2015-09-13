package runners;

import maze.AStarSearch;
import maze.BreadthFirstSearch;
import maze.DepthFirstSearch;
import maze.GreedyBestFirstSearch;
import maze.Maze;
import maze.Search;
import cheese.AStarSearchForCheese;
import cheese.CheeseMaze;

public class MainRunner {
	
	/**
	 * 
	 * @param args Enter name of search algorithm 
	 * (Cheese, BreadthFirst, DepthFirst, GreedyBestFirst, or AStar) 
	 * followed by maze file name in command line arguments
	 */
	public static void main(String[] args) {
		Maze m;
		Search search;
		String algorithm = args[0];
		if (algorithm.equalsIgnoreCase("cheese")) {
			algorithm = "A*Cheese";
			m = new CheeseMaze(args[1]);
			System.out.println("Start x = " + m.start.x);
			System.out.println("Start y = " + m.start.y);
			search = new AStarSearchForCheese((CheeseMaze) m, m.start, ((CheeseMaze)m).cheese);
		} else {
			System.out.println(args[0]);
			m = new Maze(args[1]);
			System.out.println("Start x = " + m.start.x);
			System.out.println("Start y = " + m.start.y);
			System.out.println("Goal x = " + m.goal.x);
			System.out.println("Goal y = " + m.goal.y);
			if (algorithm.equalsIgnoreCase("BreadthFirst")) {
				algorithm = "BreadthFirst";
				search = new BreadthFirstSearch(m, m.start, m.goal);
			} else if (algorithm.equalsIgnoreCase("DepthFirst")) {
				algorithm = "DepthFirst";
				search = new DepthFirstSearch(m, m.start, m.goal);
			} else if (algorithm.equalsIgnoreCase("GreedyBestFirst")) {
				algorithm = "GreedyBestFirst";
				search = new GreedyBestFirstSearch(m, m.start, m.goal);
			} else {
				algorithm = "A*";
				search = new AStarSearch(m, m.start, m.goal);
			}
		}
		//Trim file extension of maze file
		String mazeName = args[1].substring(0, args[1].lastIndexOf('.'));
		
		m.processSolution(search.getSolution(), mazeName+algorithm);
			
		
	}
}
