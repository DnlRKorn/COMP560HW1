package maze;

import java.util.Arrays;
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
	EfficenterAStar aStar;
	
	public AStarCheeseSearch(CheeseMaze c){
		aStar = new EfficenterAStar(c);
		this.c = c;
		frontier = new PriorityQueue<CheeseNode>(10 , new CheeseNodeComparator());
		CheeseNode startNode = new CheeseNode(c.start,(LinkedList<Vertex>) c.cheese.clone(),0,0,c.cheese.size(),null);
		addCheeseToFrontier(startNode);
		while(!frontier.isEmpty()){
			CheeseNode n = frontier.poll();
			if(n.listSize==0){
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
		int previous = n.pathCost + n.previousPathCost;
		System.out.println(n.cheeseList.size());
		//CheeseNode[] arrayToSort = new CheeseNode[n.listSize];
		while(iter.hasNext()){
			Vertex nextCheese = iter.next();
			LinkedList<Vertex> modifiedCheeseList = (LinkedList<Vertex>) n.cheeseList.clone();

			modifiedCheeseList.remove(nextCheese);
			//AStarSearch aStar = new AStarSearch(c, n.v, nextCheese);
			int pathCost = aStar.RunAStarSearch(n.v,nextCheese);
			frontier.add((new CheeseNode(nextCheese,modifiedCheeseList,pathCost,previous,n.listSize-1,n)));

		
	}
		
//	private void calculateArrayValue(int[] B){
//		int score = aStar.RunAStarSearch(startNode, CheeseArray[B[0]]);
//		for(int i = 0; i<Size-1;i++){
//			score += aStar.RunAStarSearch(CheeseArray[B[i]], CheeseArray[B[i+1]]);
//		}
//		if(score<curMinScore){
//			minPermuation = B;
//			curMinScore = score;
//		}
	}
	
}

class CheeseNode{
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
		return pathCost + previousPathCost + listSize - 1;
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

class CheeseNode2{
	Vertex v;
	int[] distances;
	
	public CheeseNode2(Vertex v, int[] distances){
		this.v = v;
		this.distances = distances;
	}
	
}