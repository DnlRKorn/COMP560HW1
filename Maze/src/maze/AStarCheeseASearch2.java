package maze;

import maze.CheeseMaze;
import maze.Vertex;



public class AStarCheeseASearch2 {
	
	Vertex startVertex;
	CheeseMaze c;
	CheeseNode goalNode;
	EfficenterAStar aStar;
	CheeseNode2[] cheeseNodeArray;
	int curMinScore;
	int[] minPermuation;
	
	public AStarCheeseASearch2(CheeseMaze c){
		aStar = new EfficenterAStar(c);
		this.c = c;
		curMinScore = Integer.MAX_VALUE;
		startVertex = c.start;
		Vertex[] cheeseVertexArray = (Vertex[]) (c.cheese.toArray(new Vertex[c.cheese.size()]));
		cheeseNodeArray = new CheeseNode2[cheeseVertexArray.length];
		for(int i = 0; i<cheeseVertexArray.length; i++){
			int startDis = aStar.RunAStarSearch(cheeseVertexArray[i], startVertex);
			int[] distancesToVertex = new int[cheeseVertexArray.length];
			for(int j = 0; j<cheeseVertexArray.length; j++){
				distancesToVertex[j] = aStar.RunAStarSearch(cheeseVertexArray[i], cheeseVertexArray[j]);
			}
			cheeseNodeArray[i] = new CheeseNode2(cheeseVertexArray[i],startDis,distancesToVertex);
		}
		int[] arrayOfInt = new int[cheeseNodeArray.length];
		for(int i = 0;i<cheeseNodeArray.length;i++){
			arrayOfInt[i] = i;
		}
		permute(arrayOfInt,0,arrayOfInt.length-1);
		System.out.println("hi");
		for(int i = 0;i<cheeseNodeArray.length;i++){
			System.out.printf("x: %d y: %d\n", cheeseNodeArray[minPermuation[i]].v.x, cheeseNodeArray[minPermuation[i]].v.y);
		}
	}

	void permute(int[] a, int l, int r){
		if(l == r){
			calculateArrayValue(a);
		}
		else{
			int tmp;
			for(int i = l; i<= r; i++){
				tmp = a[l];
				a[l] = a[i];
				a[i] = tmp;
				permute(a,l+1,r);
				a[i] = a[l];
				a[l] = tmp;
			}
		}
	}

		
	private void calculateArrayValue(int[] B){
		int score = cheeseNodeArray[B[0]].distanceToStart;
		for(int i = 0; i<B.length-1;i++){
			score += cheeseNodeArray[B[i]].distances[B[i+1]];
		}
		if(score<curMinScore){
			minPermuation = B.clone();
			curMinScore = score;
			System.out.println(score);
		}
	
	}
}

class CheeseNode2{
	Vertex v;
	int[] distances;
	int distanceToStart;
	
	public CheeseNode2(Vertex v, int distanceToStart, int[] distances){
		this.v = v;
		this.distanceToStart = distanceToStart;
		this.distances = distances;
	}
	
}