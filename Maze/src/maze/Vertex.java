package maze;

public class Vertex {
	public int x;
	public int y;
	
	public Vertex(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Vertex V){
		return this.x == V.x && this.y == V.y; 
	}
	
}
