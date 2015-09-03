package runners;

import maze.GreedyBestFirstSearch;
import maze.Maze;



public class GreedyRunner {

	/**
	 * 
	 * @param args Enter name of maze file in command line arguments
	 */
	public static void main(String[] args) {
		Maze m = new Maze("bigMaze.txt");
		System.out.println("Start x = " + m.start.x);
		System.out.println("Start y = " + m.start.y);
		System.out.println("Goal x = " + m.goal.x);
		System.out.println("Goal y = " + m.goal.y);
		GreedyBestFirstSearch gfs = new GreedyBestFirstSearch(m,m.start,m.goal);
		m.processSolution(gfs.getSolution());

	}
	
}
