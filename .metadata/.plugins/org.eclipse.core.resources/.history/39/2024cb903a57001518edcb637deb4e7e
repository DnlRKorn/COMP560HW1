package maze;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import maze.AStarSearch;
import maze.CheeseMaze;
import maze.Vertex;


public class AStarCheeseSearch {
	
	Queue<CheeseNode> frontier;
	CheeseMaze c;
	CheeseNode goalNode;
	
	public AStarCheeseSearch(CheeseMaze c){
		this.c = c;
		frontier = new PriorityQueue<CheeseNode>(10 , new CheeseNodeComparator());
		CheeseNode startNode = new CheeseNode(c.start,(LinkedList<Vertex>) c.cheese.clone(),0,0,null);
		addCheeseToFrontier(startNode);
		while(!frontier.isEmpty()){
			CheeseNode n = frontier.poll();
			if(n.cheeseList.size()==0){
				goalNode = n;
				break;
			}
			else{
				addCheeseToFrontier(n);
			}
		}
		
		System.out.println("Stuff");
		while(goalNode!=null){
			System.out.printf("%d, %d\n",goalNode.v.x,goalNode.v.y);
			goalNode = goalNode.parent;
		}
	}
	
	private void addCheeseToFrontier(CheeseNode n){
		Iterator<Vertex> iter = n.cheeseList.iterator();
		int previous = n.pathCost = n.previousPathCost;
		while(iter.hasNext()){
			Vertex nextCheese = iter.next();
			LinkedList<Vertex> modifiedCheeseList = (LinkedList<Vertex>) n.cheeseList.clone();

			modifiedCheeseList.remove(nextCheese);
			Vertex v = n.v;
			if(nextCheese!=null){
				AStarSearch aStar = new AStarSearch(c, n.v, nextCheese);
				int pathCost = aStar.lowestPathCost;
				frontier.add(new CheeseNode(nextCheese,modifiedCheeseList,pathCost,previous,n));
			}
		}
	}
	
}

class CheeseNode{
	Vertex v;
	LinkedList<Vertex> cheeseList;
	int pathCost;
	int previousPathCost;
	CheeseNode parent;
	
	CheeseNode(Vertex v, LinkedList<Vertex> cheeseList, int previousPathCost, int pathCost, CheeseNode parent){
		this.v = v;
		this.cheeseList = cheeseList;
		this.pathCost = pathCost;
		this.previousPathCost = previousPathCost;
		this.parent = parent;
	}
	
	int heurisitic(){
		return pathCost + previousPathCost + cheeseList.size() - 1;
	}
}

class CheeseNodeComparator implements Comparator<CheeseNode> {

	public int compare(CheeseNode a, CheeseNode b) {
		if(a.heurisitic() < b.heurisitic()){
			return -1;
		}
		else if(a.heurisitic() == b.heurisitic()){
			return 0;
		}
		return 1;
	}

}
