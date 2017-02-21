import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static boolean compareSkeletons(Graph G1, Graph G2){
		Graph Skeleton1 = G1.generateSkeleton();
		Graph Skeleton2 = G2.generateSkeleton();
		
		System.out.println("Graph1 Skeleton: ");
		for(int i = 0;i<Skeleton1.getEdgeList().size();i++){
			System.out.print("(" + Skeleton1.getEdgeList().get(i).getFromNode().getId()+", " +Skeleton1.getEdgeList().get(i).getToNode().getId()+ ")");
		}
		System.out.println(" ");
		
		System.out.println("Graph2 Skeleton: ");
		for(int i = 0;i<Skeleton1.getEdgeList().size();i++){
			System.out.print("(" + Skeleton2.getEdgeList().get(i).getFromNode().getId()+", " +Skeleton2.getEdgeList().get(i).getToNode().getId()+ ")");
		}
		System.out.println(" ");
		
		if(Skeleton1.getNodeList().size() != Skeleton2.getNodeList().size()){
			return false;
		}
		
		if(Skeleton1.getEdgeList().size() != Skeleton2.getEdgeList().size() )
			return false;
	
		boolean foundEdge = false;
		for(Edge aux: Skeleton1.getEdgeList()){
			foundEdge = false;
			for(Edge aux2: Skeleton2.getEdgeList()){
				if(((aux.getFromNode().getId()==aux2.getFromNode().getId())&&(aux.getToNode().getId()==aux2.getToNode().getId()))){
					foundEdge = true;
				}
			}
			if(!foundEdge)
				break;
		}
		
		System.out.println("Equal Skeletons : " + foundEdge);
		return foundEdge;
	}
	
	public static boolean compareImoralities(Graph G1, Graph G2){
		
		ArrayList<ArrayList<Node>> imoralities1 = G1.generateImoralities();
		ArrayList<ArrayList<Node>> imoralities2 = G2.generateImoralities();
		
		System.out.println("Graph 1 Imoralities: ");
		for(int i = 0; i<imoralities1.size();i++){
			System.out.print("(");
			for(int j = 0; j<imoralities1.get(i).size();j++){
				System.out.print(imoralities1.get(i).get(j).getId() +", ");
			}
			System.out.println(")");
		}
		
		System.out.println("Graph 2 Imoralities: ");
		for(int i = 0; i<imoralities2.size();i++){
			System.out.print("(");
			for(int j = 0; j<imoralities2.get(i).size();j++){
				System.out.print(imoralities2.get(i).get(j).getId() +", ");
			}
			System.out.println(")");
		}
		
		if(imoralities1.size() != imoralities2.size()){
			return false;
		}
		
		boolean foundImorality = false;
		for(ArrayList<Node> aux: imoralities1){
			foundImorality = false;
			for(ArrayList<Node> aux2: imoralities2){
				if(((aux.get(0).getId()==aux2.get(0).getId())&&(aux.get(1).getId()==aux2.get(1).getId())&&(aux.get(2).getId()==aux2.get(2).getId()))){
					foundImorality = true;
				}
			}
			if(!foundImorality)
				break;
		}
		
		System.out.println("Equal Imoralities: "+ foundImorality);
		return foundImorality;
	}
	
	public static boolean checkMarkovEquivalence(Graph G1, Graph G2){
		if(compareSkeletons(G1, G2) && compareImoralities(G1, G2))
			return true;
		return false;
	}
	
	public static void main(String args[]) throws IOException{
		CSVHandler handler = new CSVHandler();
		Graph G1 = handler.readMatrixFile("matrixA.csv");
		Graph G2 = handler.readMatrixFile("matrixB.csv");
		
		System.out.println("Graph 1:");
		for(int i = 0; i<G1.getEdgeList().size();i++){
			System.out.print("(" + G1.getEdgeList().get(i).getFromNode().getId()+", " +G1.getEdgeList().get(i).getToNode().getId()+ ")");
		}
		System.out.println(" ");
		
		System.out.println("Graph 2:");
		for(int i = 0; i<G2.getEdgeList().size();i++){
			System.out.print("(" + G2.getEdgeList().get(i).getFromNode().getId()+", " +G2.getEdgeList().get(i).getToNode().getId()+ ")");
		}
		System.out.println(" ");
		
		System.out.println(checkMarkovEquivalence(G1, G2));
		
	}
}
