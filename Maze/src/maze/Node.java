package maze;

import maze.Maze.Direction;

public class Node {
	
	static Maze maze;
	int pathCost;
	int manhattanDistance;
	public Vertex nodeVertex; //Vertex which is represented by this node
	public Node parent; //Pointer to parent node
	Direction parentDirection;
	
	public Node(Vertex v, Node p, Direction parentD, int c){
		nodeVertex = v;
		parent = p;
		parentDirection = parentD;
		pathCost = c;
	}
	
	public Node(Vertex v, Node p, Direction parentD, int c,int d){
		nodeVertex = v;
		parent = p;
		parentDirection = parentD;
		pathCost = c;
		manhattanDistance = d;
	}

}
