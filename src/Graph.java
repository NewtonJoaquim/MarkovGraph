import java.util.ArrayList;
import java.util.Map;

public class Graph {
	private ArrayList<Node> nodeList = new ArrayList<Node>();
	private ArrayList<Edge> edgeList = new ArrayList<Edge>();
	
	public Graph(ArrayList<Node> nodeList, ArrayList<Edge> edgeList) {
		super();
		this.nodeList = nodeList;
		this.edgeList = edgeList;
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

	public ArrayList<Edge> getEdgeList() {
		return edgeList;
	}
	
	public boolean checkEdge(Node n1, Node n2){
		for(Edge aux : this.getEdgeList()){
			if(((aux.getFromNode() == n1)&&(aux.getToNode() == n2))||
					((aux.getToNode() == n1)&&(aux.getFromNode() == n2))){
				return true;
			}
		}
		return false;
	}
	
	public Graph generateSkeleton(){
		Graph G;
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		
		for(int i = 0; i<this.getEdgeList().size();i++){
			edgeList.add(new Edge(this.edgeList.get(i).getFromNode(), this.edgeList.get(i).getToNode()));
			edgeList.add(new Edge(this.edgeList.get(i).getToNode(), this.edgeList.get(i).getFromNode()));
		}
		
		G = new Graph(this.nodeList, edgeList);
		
		return G;
	}
	
	public ArrayList<ArrayList<Node>> generateImoralities(){
		
		ArrayList<Node> imorality = new ArrayList<Node>();
		ArrayList<ArrayList<Node>> imoralityList = new ArrayList<ArrayList<Node>>();
		
		for(int i = 0; i<this.getEdgeList().size();i++){
			for(int j = 0; j<this.getEdgeList().size();j++){
				if(i != j){
					if((this.getEdgeList().get(i).getToNode() == this.getEdgeList().get(j).getToNode())&&
							(!checkEdge(this.getEdgeList().get(i).getFromNode(), this.getEdgeList().get(j).getFromNode()))) {
						
						imorality.add(this.getEdgeList().get(i).getFromNode());
						imorality.add(this.getEdgeList().get(j).getFromNode());
						imorality.add(this.getEdgeList().get(i).getToNode());
						
						imoralityList.add(imorality);
						
						imorality = new ArrayList<Node>();
					}
				}
			}
		}
		
		return imoralityList;
	}
}
