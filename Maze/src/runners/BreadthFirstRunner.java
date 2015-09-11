package runners;

import maze.BreadthFirstSearch;
import maze.Maze;

public class BreadthFirstRunner {
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
		BreadthFirstSearch bfs = new BreadthFirstSearch(m,m.start,m.goal);
		m.processSolution(bfs.getSolution());

	}
}
