package cheese;

import java.util.LinkedList;
import java.util.PriorityQueue;

import maze.AStarNodeComparator;
import maze.Maze;
import maze.Node;
import maze.Search;
import maze.Vertex;

public class EfficenterAStar extends Search{
	
	public EfficenterAStar(Maze m){
		//Initialize variables
		maze = m;
	}
	
	public int RunAStarSearch(Vertex start, Vertex goal){
		//Initialize variables
		startSpace = start;
		goalSpace = goal;
		//Frontier is priority queue in A* Search
		frontier = new PriorityQueue<Node>(10 , new AStarNodeComparator());
		frontier.add(new Node(start, null, null, 0, manhattanDistance(startSpace, goalSpace)));
		exploredSet = new LinkedList<Vertex>();
		Node goalNode = null;
		boolean goalFound = false;
		//Process nodes in the frontier
		while(!goalFound && !frontier.isEmpty()){
			Node n = ((PriorityQueue<Node>) frontier).poll();
			Vertex v = n.nodeVertex;
			if(v.equals(goalSpace)){
				goalFound = true;
				goalNode = n;
			}
			else{
				exploredSet.add(v);
				expandNode(n);
			}
		}
		return goalNode.pathCost;
	}
	
}
