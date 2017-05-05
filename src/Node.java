import java.util.ArrayList;

public class Node {

	private String word;
	ArrayList<Connection> connectionIn;
	ArrayList<Connection> connectionOut;

	
	public Node(String word){
		this.word = word;
		connectionIn = new ArrayList<Connection>();
		connectionOut = new ArrayList<Connection>();

	}
	
	public ArrayList<Node> getAllOutNodes(){
		ArrayList<Node> out = new ArrayList<Node>();
		
		for(int i = 0; i < connectionOut.size(); i++){
			out.add(connectionOut.get(i).getA());
		}
		
		return out;
	}

	public String getWord() {
		return word;
	}
	
	
}
