package maze;

import java.util.LinkedList;

public class CheeseMaze extends Maze{

	public LinkedList<Vertex> cheese;

	public CheeseMaze(String fileLoc){
		generateStringList(fileLoc);
		if(!stringList.isEmpty())
			generateMazeArray();
	}
	
	public boolean isCheese(Vertex v){
		return cheese.contains(v);
	}
	@Override
	protected void generateMazeArray(){
		//Identify width of maze based on length of first line
		mazeWidth = stringList.get(0).length();
		//Identify height of maze based on length of arrayList
		mazeHeight = stringList.size();
		//Initialize maze array to proper dimensions
		mazeArray = new boolean[mazeWidth][mazeHeight];
		cheese = new LinkedList<Vertex>();
		
		//Fill in array line by line
		for(int y = 0; y < mazeHeight; y++){
			String currentLine = stringList.get(y);
			for(int x = 0; x < mazeWidth; x++){
				//If current space is '%', mark as not traversable
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
					//If current space is '.', record cheese space
					if(currentLine.charAt(x) == '.')
						cheese.add(new Vertex(x, y));
					//Mark space as traversable
					mazeArray[x][y] = true;
				}
			}
		}
	}
}
