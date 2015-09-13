package cheese;

import java.util.Stack;

import maze.Vertex;



public class BruteForceAStarCheeseSearch {
	
	Vertex startVertex;
	CheeseMaze c;
	CheeseNode goalNode;
	EfficentAStar aStar;
	BruteForceCheeseNode[] cheeseNodeArray;
	Stack<Vertex> solutionStack;
	int curMinScore;
	int[] minPermuation;
	
	public BruteForceAStarCheeseSearch(CheeseMaze c){
		aStar = new EfficentAStar(c);
		this.c = c;
		curMinScore = Integer.MAX_VALUE;
		startVertex = c.start;
		Vertex[] cheeseVertexArray = (Vertex[]) (c.cheese.toArray(new Vertex[c.cheese.size()]));
		cheeseNodeArray = new BruteForceCheeseNode[cheeseVertexArray.length];
		for(int i = 0; i<cheeseVertexArray.length; i++){
			int startDis = aStar.RunAStarSearch(cheeseVertexArray[i], startVertex);//calculates and saves the distance from cheese node i to the start nodes
			int[] distancesToVertex = new int[cheeseVertexArray.length];
			for(int j = 0; j<cheeseVertexArray.length; j++){
				distancesToVertex[j] = aStar.RunAStarSearch(cheeseVertexArray[i], cheeseVertexArray[j]);//calculates the distance from node i to node j
			}
			cheeseNodeArray[i] = new BruteForceCheeseNode(cheeseVertexArray[i],startDis,distancesToVertex);
		}
		int[] arrayOfInt = new int[cheeseNodeArray.length];
		for(int i = 0;i<cheeseNodeArray.length;i++){
			arrayOfInt[i] = i;//Builds an array of integers from  0 to n-1 for the number of cheese nodes in the index
		}
		permute(arrayOfInt,0,arrayOfInt.length-1);
		solutionStack = new Stack<Vertex>();
		for(int i = 0;i<cheeseNodeArray.length;i++){
			//System.out.printf("x: %d y: %d\n", cheeseNodeArray[minPermuation[i]].v.x, cheeseNodeArray[minPermuation[i]].v.y);
			solutionStack.push(cheeseNodeArray[minPermuation[i]].v);
		}
	}

	void permute(int[] a, int curIndex, int endIndex){//Generates all possible n! permuations of an array
		if(curIndex == endIndex){
			calculateArrayValue(a);
		}
		else{
			int tmp;
			for(int i = curIndex; i<= endIndex; i++){
				tmp = a[curIndex];
				a[curIndex] = a[i];
				a[i] = tmp;
				permute(a,curIndex+1,endIndex);
				a[i] = a[curIndex];
				a[curIndex] = tmp;
			}
		}
	}

		
	private void calculateArrayValue(int[] B){//calculates the sum of all distances on unique array permuations, assuming the path always begins at the start node and then proceeds to cheese node at B[0] then to B[1] and so on until B[n-1]
		int score = cheeseNodeArray[B[0]].distanceToStart;
		for(int i = 0; i<B.length-1;i++){
			score += cheeseNodeArray[B[i]].distances[B[i+1]];
		}
		if(score<curMinScore){//If the score is lower than the max score, save the score and the ordering of the cheese indexes
			minPermuation = B.clone();
			curMinScore = score;
		}
	}
}

class BruteForceCheeseNode{
	Vertex v;
	int[] distances;
	int distanceToStart;
	
	public BruteForceCheeseNode(Vertex v, int distanceToStart, int[] distances){
		this.v = v;
		this.distanceToStart = distanceToStart;
		this.distances = distances;
	}
	
}