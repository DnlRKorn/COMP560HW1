package cheese;

import java.util.LinkedList;

import maze.Vertex;

public class CheeseNode{
	Vertex v;
	LinkedList<Vertex> cheeseList;
	int pathCost;
	int previousPathCost;
	int listSize;
	CheeseNode parent;
	
	CheeseNode(Vertex v, LinkedList<Vertex> cheeseList, int previousPathCost, int pathCost, int listSize, CheeseNode parent){
		this.v = v;
		this.cheeseList = cheeseList;
		this.pathCost = pathCost;
		this.previousPathCost = previousPathCost;
		this.listSize = listSize;
		this.parent = parent;
	}
	
	int heurisitic(){
		return (int) (pathCost + previousPathCost + listSize * 2 - 1);
	}
}