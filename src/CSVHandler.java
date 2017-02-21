import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVHandler {
	public Graph readMatrixFile(String file) throws IOException{
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		int id = 1;
		
		String line;
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			line = br.readLine();
			String[] lineField = line.split(",");
			for(int i = 0; i<lineField.length; i++){
				nodeList.add(new Node(i));
			}
			for(int i = 0; i<lineField.length; i++){
				if(Integer.parseInt(lineField[i]) == 1)
					edgeList.add(new Edge(nodeList.get(0), nodeList.get(i)));
			}
			
			while ((line = br.readLine()) != null){
				lineField = line.split(",");	
				for(int i = 0;i<lineField.length; i++){
					if(Integer.parseInt(lineField[i]) == 1){
						edgeList.add(new Edge(nodeList.get(id), nodeList.get(i)));
					}
				}
				id++;
			}
		}catch(Exception e){
			e.getMessage();
		}
		
		Graph G = new Graph(nodeList, edgeList);
		return G;
	}	
}