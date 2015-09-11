package maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class Maze {

	//Top-left of maze is coordinate (0, 0)
	//Entry is 'true' if space is traversible,
	//'false' if not.
	public boolean[][] mazeArray;

	public enum Direction{
		up, down, left, right
	}
	
	public Vertex goal;
	public Vertex start;

	public int mazeWidth;
	public int mazeHeight;
	public String mazeName;
	protected ArrayList<String> stringList;
	
	public Maze(){
		
	}
	
	public Maze(String fileLoc){
		generateStringList(fileLoc);
		if(!stringList.isEmpty())
			generateMazeArray();
	}
	
	//Checks if the vertex in direction d from vertex v is traversible.
	public boolean canMoveInDirection(Vertex v, Direction d){
		if(d == Direction.left){
			return mazeArray[v.x-1][v.y];
		}
		else if(d == Direction.right){
			return mazeArray[v.x+1][v.y];
		}
		else if(d == Direction.down){
			return mazeArray[v.x][v.y+1];
		}
		else if(d == Direction.up){
			return mazeArray[v.x][v.y-1];
		}
		//Unknown value of d
		else
			return false;	
	}
	
	public boolean isGoalVertex(Vertex v){
		return v.equals(goal);
	}
	
	/*
	 * Reads in maze text file and stores as array of Strings.
	 */
	protected ArrayList<String> generateStringList(String fileLoc){
		BufferedReader br;
		stringList = new ArrayList<String>(); 
		try {
			br = new BufferedReader (new FileReader(fileLoc) );
			//Read in text file line by line
			for(String input = br.readLine(); input != null; input = br.readLine()){
				stringList.add(input);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringList;
	}

	protected void generateMazeArray(){
		//Identify width of maze based on length of first line
		mazeWidth = stringList.get(0).length();
		//Identify height of maze based on length of arrayList
		mazeHeight = stringList.size();
		//Initialize maze array to proper dimensions
		mazeArray = new boolean[mazeWidth][mazeHeight];
		
		//Fill in array line by line
		for(int y = 0; y < mazeHeight; y++){
			String currentLine = stringList.get(y);
			for(int x = 0; x < mazeWidth; x++){
				//If current space is '%', mark as not traversible
				if(currentLine.charAt(x) == '%'){
					mazeArray[x][y] = false;
				}
				else{
					//If current space is 'S', record start space
					if(currentLine.charAt(x) == 'S')
						start = new Vertex(x, y);
					//If current space is 'G', record goal space
					if(currentLine.charAt(x) == 'G')
						goal = new Vertex(x, y);
					//Mark space as traversible
					mazeArray[x][y] = true;
				}
			}
		}
	}
	/*
	 * Goes through solution path and 
	 * changes spaces traversed to '.'
	 */
	public void processSolution(Stack<Vertex> solution){ 
		while(!solution.isEmpty()){
			Vertex currentVertex = solution.pop();
			int currentX = currentVertex.x;
			int currentY = currentVertex.y;
			//If not G or S space
			if (stringList.get(currentY).charAt(currentX) != 'G'
					&& stringList.get(currentY).charAt(currentX) != 'S') {
				//Recreate entry at currentY in stringList, replacing traversed space with '.'
				//Uses StringBuilder due to Java Strings being immutable
				StringBuilder solutionString = new StringBuilder(stringList.get(currentY));
				solutionString.setCharAt(currentX, '.'); 
				stringList.set(currentY, solutionString.toString());
			}
		}
		for(int i = 0; i < stringList.size(); i++){
			System.out.println(stringList.get(i));
		}
	}

	
}
