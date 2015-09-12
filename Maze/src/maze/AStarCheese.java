package maze;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarCheese {
/*	Vertex startSpace;
	Vertex goalSpace;
	Queue<CheeseNode> frontier;
	LinkedList<ExploredSetVertex> exploredSet;
	LinkedList<Vertex> exploredSetCheese;
	LinkedList<Vertex> currentCheese;
	CheeseMaze m;
	
	
	public AStarCheese(CheeseMaze m, Vertex start, LinkedList<Vertex> cheese){
		startSpace = start;
//		currentCheese = (LinkedList<Vertex>) cheese.clone();
		exploredSet = new LinkedList<ExploredSetVertex>();
		exploredSetCheese = new LinkedList<Vertex>();
//		getGoal(startSpace, currentCheese);
		frontier = new PriorityQueue<CheeseNode>(10 , new CheeseNodeComparator());
		frontier.add(new CheeseNode(start, (LinkedList<Vertex>) cheese.clone(), 0));
		ExploredSetVertex temp;
		LinkedList<Vertex> tempCheese;
//		Node goalNode = null;
		boolean goalFound = false;
		int expandedNodes = 0;
		int counter = 0;
		CheeseNode goalNode = null;
					
		while(!goalFound && !frontier.isEmpty()){
			CheeseNode n = frontier.poll();
			expandedNodes++;
			Vertex v = n.nodeVertex;
			if(n.cheeseList.size()==0){
				goalFound = true;
				goalNode = n;
			}
			else{
				exploredSet.add(new ExploredSetVertex(v,n.cheeseList.size()));
/*				if(m.canMoveLeft(n.nodeVertex)){
						temp = new ExploredSetVertex(new Vertex(v.x-1,v.y),n.cheeseList.size());
						if(!checkIfWorseThanExploredSet(temp)){
							tempCheese = (LinkedList<Vertex>) n.cheeseList.clone();
							if(tempCheese.contains(temp.v)){
								tempCheese.remove(temp.v);
							}
							System.out.printf("Adding Vertex (%d,%d) with node count %d \n",temp.v.x,temp.v.y, tempCheese.size());
							frontier.add(new CheeseNode(temp.v, tempCheese, n.pathCost+1));
						}
					}
					if(m.canMoveDown(v)){
						temp = new ExploredSetVertex(new Vertex(v.x,v.y-1),n.cheeseList.size());
						if(!checkIfWorseThanExploredSet(temp)){
							tempCheese = (LinkedList<Vertex>) n.cheeseList.clone();
							if(tempCheese.contains(temp.v)){
								tempCheese.remove(temp.v);
							}
							System.out.printf("Adding Vertex (%d,%d) with node count %d \n",temp.v.x,temp.v.y, tempCheese.size());
							frontier.add(new CheeseNode(temp.v, tempCheese, n.pathCost+1));
						}
					}*/
/*					if(m.canMoveRight(v)){
						temp = new ExploredSetVertex(new Vertex(v.x+1,v.y),n.cheeseList.size());
						if(!checkIfWorseThanExploredSet(temp)){
							tempCheese = (LinkedList<Vertex>) n.cheeseList.clone();
							if(tempCheese.contains(temp.v)){
								tempCheese.remove(temp.v);
							}
							System.out.printf("Adding Vertex (%d,%d) with node count %d \n",temp.v.x,temp.v.y, tempCheese.size());
							frontier.add(new CheeseNode(temp.v, tempCheese, n.pathCost+1));
						}
					}
/*					if(m.canMoveUp(v)){
						temp = new ExploredSetVertex(new Vertex(v.x,v.y+1),n.cheeseList.size());
						if(!checkIfWorseThanExploredSet(temp)){
							tempCheese = (LinkedList<Vertex>) n.cheeseList.clone();
							if(tempCheese.contains(temp.v)){
								tempCheese.remove(temp.v);
							}
							System.out.printf("Adding Vertex (%d,%d) with node count %d \n",temp.v.x,temp.v.y, tempCheese.size());
							frontier.add(new CheeseNode(temp.v, tempCheese, n.pathCost+1));
						}
					}
				}
			}
		
//			while(goalNode!=null){
//				System.out.printf("x:%d y:%d\n", goalNode.nodeVertex.x,goalNode.nodeVertex.y);
//				goalNode = goalNode.parent;
//				counter++;
//			}
		
			System.out.printf("Number of steps %d\n", counter);
			System.out.printf("Number of nodes expanded %d\n", expandedNodes);
			
			startSpace = goalSpace;
//			getGoal(startSpace, currentCheese);
			
	}
	
	private boolean checkIfWorseThanExploredSet(ExploredSetVertex v){
		Iterator<ExploredSetVertex> iter = exploredSet.iterator();
		while(iter.hasNext()){
			ExploredSetVertex ex = iter.next();
			if(ex.v.equals(v)){
				if(ex.heuristic < v.heuristic){
					return true;
				}
				else{
					return false;
				}
			}
		}
		return false;
	}
	
	private boolean checkIfInExploredSetCheese(Vertex v){
		Iterator<Vertex> iter = exploredSetCheese.iterator();
		while(iter.hasNext()){
			if(iter.next().equals(v)){
				return true;
			}
		}
		return false;
	}
	
	private int manhattanDistance(Vertex v){
		return Math.abs(v.x-goalSpace.x)+Math.abs(v.y-goalSpace.y);
	}
	
	private int absDistance(Vertex v, Vertex w){
		return Math.abs(v.x-w.x)+Math.abs(v.y-w.y);
	}

	private void getGoal(Vertex start, LinkedList<Vertex> cheese){
		int tempDistance = -1;
		LinkedList<Vertex> forDel = new LinkedList<Vertex>();
		if (cheese.isEmpty()){
			goalSpace = null;
			return;
		}else{
			for (Vertex item : cheese){
				if (!exploredSet.isEmpty()){
					if (checkIfInExploredSetCheese(item)){
						forDel.add(item);
					}
				}
			}
			if (!forDel.isEmpty()){
				for (Vertex item : forDel){
					cheese.remove(item);
				}
			}
			for (Vertex item : cheese){
				if (tempDistance == -1){
					tempDistance = absDistance(start, item);
					goalSpace = item;
					continue;
				}
				if (absDistance(start, item) < tempDistance){
					tempDistance = absDistance(start, item);
					goalSpace = item;
				}
			}
		}
		cheese.remove(goalSpace);
	}*/
}
