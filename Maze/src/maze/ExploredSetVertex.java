package maze;

public class ExploredSetVertex {
	public Vertex v;
	public int heuristic;
	
	public ExploredSetVertex(Vertex v, int heuristic){
		this.v = v;
		this.heuristic = heuristic;
	}
	
}
