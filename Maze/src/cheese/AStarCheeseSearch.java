package cheese;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


import java.util.Stack;

import maze.Vertex;


public class AStarCheeseSearch {
	
	Queue<AStarCheeseNode> frontier;
	CheeseMaze c;
	AStarCheeseNode goalNode;
	EfficentAStar aStarSearch;
	Stack<Vertex> solutionStack;
	
	public AStarCheeseSearch(CheeseMaze c){
		aStarSearch = new EfficentAStar(c);
		this.c = c;
		frontier = new PriorityQueue<AStarCheeseNode>(10 , new AStarCheeseNodeComparator());
		AStarCheeseNode startNode = new AStarCheeseNode(c.start,(LinkedList<Vertex>) c.cheese.clone(),0,0,null);
		addCheeseToFrontier(startNode);
		while(!frontier.isEmpty()){
			AStarCheeseNode n = frontier.poll();
			if(n.cheeseList.size()==0){
				goalNode = n;
				break;
			}
			else{
				addCheeseToFrontier(n);
			}
		}
		
		while(goalNode!=null){
			System.out.printf("%d, %d\n",goalNode.v.x,goalNode.v.y);
			goalNode = goalNode.parent;
		}
	}
	
	private void addCheeseToFrontier(AStarCheeseNode n){
		Iterator<Vertex> iter = n.cheeseList.iterator();
		int previous = n.pathCost + n.previousPathCost;
		while(iter.hasNext()){
			Vertex nextCheese = iter.next();
			LinkedList<Vertex> modifiedCheeseList = (LinkedList<Vertex>) n.cheeseList.clone();

			modifiedCheeseList.remove(nextCheese);
			Vertex v = n.v;
			if(nextCheese!=null){
				int pathCost = aStarSearch.RunAStarSearch(v, nextCheese);
				frontier.add(new AStarCheeseNode(nextCheese,modifiedCheeseList,pathCost,previous,n));
			}
		}
	}
	
}

class AStarCheeseNode{
	Vertex v;
	LinkedList<Vertex> cheeseList;
	int pathCost;
	int previousPathCost;
	AStarCheeseNode parent;
	
	AStarCheeseNode(Vertex v, LinkedList<Vertex> cheeseList, int previousPathCost, int pathCost, AStarCheeseNode parent){
		this.v = v;
		this.cheeseList = cheeseList;
		this.pathCost = pathCost;
		this.previousPathCost = previousPathCost;
		this.parent = parent;
	}
	
	int heurisitic(){
		return pathCost + previousPathCost + (int) Math.round(1.5
				*(cheeseList.size() - 1));
	}
}

class AStarCheeseNodeComparator implements Comparator<AStarCheeseNode> {

	public int compare(AStarCheeseNode a, AStarCheeseNode b) {
		if(a.heurisitic() < b.heurisitic()){
			return -1;
		}
		else if(a.heurisitic() == b.heurisitic()){
			return 0;
		}
		return 1;
	}

}