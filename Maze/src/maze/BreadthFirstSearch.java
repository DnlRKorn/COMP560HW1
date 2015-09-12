package maze;

import java.util.LinkedList;
import java.util.Stack;

public class BreadthFirstSearch extends Search{
	
	public BreadthFirstSearch(Maze m, Vertex start, Vertex goal){
		//Initialize variables
		maze = m;
		solution = new Stack<Vertex>();
		startSpace = start;
		goalSpace = goal;
		//Frontier is a list in Breadth-first Search
		frontier = new LinkedList<Node>();
		exploredSet = new LinkedList<Vertex>();
		frontier.add(new Node(start, null, null, 0));
		Node goalNode = null;
		boolean goalFound = false;
		int expandedNodes = 0;
		//Process nodes in the frontier
		while(!(frontier.isEmpty()||goalFound)){
			Node n = ((LinkedList<Node>) frontier).poll();
			expandedNodes++;
			Vertex v = n.nodeVertex;
			if(m.isGoalVertex(v)){
				goalFound = true;
				goalNode = n;
			}
			else{
				exploredSet.add(v);
				expandNode(n);
			}

		}
		int stepCounter = 0;
		//Retrace parent node pointers to find solution once goal is reached
		Node currentNode = goalNode;
		while(currentNode!=null){
			solution.add(currentNode.nodeVertex);
			System.out.printf("x:%d y:%d\n", currentNode.nodeVertex.x,currentNode.nodeVertex.y);
			//Update currentNode to parent node pointer
			currentNode = currentNode.parent;
			stepCounter++;
		}
		System.out.printf("Number of steps %d\n", stepCounter);
		System.out.printf("Number of nodes expanded %d\n", expandedNodes);

	}
	
	
}