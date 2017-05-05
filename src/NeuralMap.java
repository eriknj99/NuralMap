import java.util.ArrayList;

public class NeuralMap {
	
	private ArrayList<Node> nodes;
	private ArrayList<Connection> connections;
	
	public NeuralMap(){
		nodes = new ArrayList<Node>();
		connections = new ArrayList<Connection>();
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public void build(ArrayList<ArrayList<String>> allWords){
		
		long totalT = System.currentTimeMillis();
		
		for(int i = 0; i < allWords.size(); i++){
			
			long t = System.currentTimeMillis();
			
			nodes.add(new Node(allWords.get(i).get(0)));
			int currentNode = nodes.size() - 1;
			System.out.print("Processing index " + i + "...");
						
			for(int x = 0; x < allWords.get(i).size(); x++){
				int doesContain = doesNodesContain(allWords.get(i).get(x));
				
				if(doesContain == -1){
					
					nodes.add(new Node(allWords.get(i).get(x)));
					connections.add(new Connection(nodes.get(currentNode), nodes.get(nodes.size() - 1)));
					currentNode = nodes.size() - 1;
					
				}else{
					
					Connection temp = new Connection(nodes.get(currentNode), nodes.get(doesContain));
					int doesContainC = doesConnectionsContain(temp);
					
					
					if(doesContainC == -1){
						connections.add(temp);
					}else{
						connections.get(doesContainC).incrementUses();
					}
				}
			}
				System.out.println("done. " + ((double)(System.currentTimeMillis() - t) / 1000) + "s");

		}
		System.out.println("done. " + ((double)(System.currentTimeMillis() - totalT) / 1000) + "s");


	}
	
	private int doesNodesContain(String in){
		for(int i = 0; i < nodes.size(); i++){
			if(nodes.get(i).getWord().equals(in)){
				return i;
			}
		}
		return -1;
	}
	
	private int doesConnectionsContain(Connection in){
		for(int i = 0; i < connections.size();i++){
			if(connections.get(i).getA().getWord().equals(in.getA().getWord()) && connections.get(i).getB().getWord().equals(in.getB().getWord())){
				return i;
			}
		}
		return -1;
	}
	
	public String toString(){
		return "";
	}

}
