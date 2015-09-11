package maze;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import maze.Maze.Direction;
/**
 * Abstract class extended by 
 * search algorithm classes. 
 *
 */
public abstract class Search {
	Vertex startSpace;
	Vertex goalSpace;
	Collection<Node> frontier;
	LinkedList<Vertex> exploredSet;
	Maze maze;
	Stack<Vertex> solution;
	
	public Stack<Vertex> getSolution(){
		return solution;
	}
	
	protected void expandNode(Node n){
		//Attempt to expand in each of the four directions from n
		expandInDirection(Direction.left, n);
		expandInDirection(Direction.down, n);
		expandInDirection(Direction.right, n);
		expandInDirection(Direction.up, n);
	}
	
	private void expandInDirection(Direction d, Node n){
		Vertex v = n.nodeVertex;
		Vertex temp;
		if(maze.canMoveInDirection(v, d)){
			//Initialize temp based on the value of d
			if(d == Direction.left){
				temp = new Vertex(v.x-1,v.y);
			}
			else if(d == Direction.right){
				temp = new Vertex(v.x+1,v.y);
			}
			else if(d == Direction.down){
				temp = new Vertex(v.x,v.y+1);
			}
			else{
				temp = new Vertex(v.x, v.y-1);
			}
			if(!inExploredSet(temp)){
				//System.out.printf("Adding Vertex (%d,%d)\n",temp.x,temp.y);
				
				//Different methods for adding to frontier based 
				//on what data structure the frontier is.
				if(frontier instanceof Queue)
					frontier.add(new Node(temp,n,d,n.pathCost+1,manhattanDistance(temp)));
				else
					((Stack<Node>)frontier).push(new Node(temp,n,d,n.pathCost+1,manhattanDistance(temp)));
			}
		}
	}
	
	//Checks to see if a vertex v is in the explored set.
	protected boolean inExploredSet(Vertex v){
		Iterator<Vertex> iter = exploredSet.iterator();
		while(iter.hasNext()){
			if(iter.next().equals(v)){
				return true;
			}
		}
		return false;
	}
	
	//Returns the Manhattan Distance from vertex v to the goal space
	protected int manhattanDistance(Vertex v){
		return Math.abs(v.x-goalSpace.x)+Math.abs(v.y-goalSpace.y);
	}
}
