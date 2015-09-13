package cheese;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
	}
	
}

//class CheeseNode2{
//	Vertex v;
//	int[] distances;
//	
//	public CheeseNode2(Vertex v, int[] distances){
//		this.v = v;
//		this.distances = distances;
//	}
//	
//}

