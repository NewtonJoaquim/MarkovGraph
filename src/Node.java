import java.util.ArrayList;

public class Node {
	private int id;
	
	public Node(int id) {
		super();
		this.id = id;
	}	
	
	public int getId() {
		return id;
	}

	public ArrayList<Node> adjacencyList(Graph G){
		ArrayList<Node> nodeList = new ArrayList<Node>();
	
		for(int i = 0; i<G.getEdgeList().size();i++){
			if(G.getEdgeList().get(i).getFromNode().getId() == this.id){
				nodeList.add(G.getEdgeList().get(i).getToNode());
			}
			else if(G.getEdgeList().get(i).getToNode().getId() == this.id){
				nodeList.add(G.getEdgeList().get(i).getFromNode());
			}
		}
		
		return nodeList;
	}
	
}
