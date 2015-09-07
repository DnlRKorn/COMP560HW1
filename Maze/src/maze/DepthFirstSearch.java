package maze;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends Search{

	public DepthFirstSearch(Maze m, Vertex start, Vertex goal){
		//Initialize variables
		maze = m;
		solution = new Stack<Vertex>();
		startSpace = start;
		goalSpace = goal;
		//Frontier is stack in Depth-first Search
		frontier = new Stack<Node>();
		exploredSet = new LinkedList<Vertex>();
		((Stack<Node>) frontier).push(new Node(start, null, null, 0));
		Node goalNode = null;
		boolean goalFound = false;
		//Process nodes in the frontier
		while(!(frontier.isEmpty()||goalFound)){
			Node n = ((Stack<Node>) frontier).pop();
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
	}
	
}
