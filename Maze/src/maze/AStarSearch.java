package maze;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class AStarSearch extends Search{

	public int lowestPathCost;

	public AStarSearch(Maze m, Vertex start, Vertex goal){
		//Initialize variables
		maze = m;
		solution = new Stack<Vertex>();
		startSpace = start;
		goalSpace = goal;
		//Frontier is priority queue in A* Search
		frontier = new PriorityQueue<Node>(10 , new AStarNodeComparator());
		frontier.add(new Node(start, null, null, 0, manhattanDistance(start)));
		exploredSet = new LinkedList<Vertex>();
		Node goalNode = null;
		boolean goalFound = false;
		int expandedNodes = 0;
		//Process nodes in the frontier
		while(!goalFound && !frontier.isEmpty()){
			Node n = ((PriorityQueue<Node>) frontier).poll();
			expandedNodes++;
			Vertex v = n.nodeVertex;
			if(v.equals(goal)){
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
		lowestPathCost = goalNode.pathCost;
		while(currentNode!=null){
			solution.add(currentNode.nodeVertex);
//		System.out.printf("x:%d y:%d\n", currentNode.nodeVertex.x,currentNode.nodeVertex.y);
			//Update currentNode to parent node pointer
			currentNode = currentNode.parent;
			stepCounter++;
		}
		System.out.printf("Number of steps %d\n", stepCounter);
		System.out.printf("Number of nodes expanded %d\n", expandedNodes);
		
	}

}