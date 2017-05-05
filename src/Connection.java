
public class Connection {

	private Node a;
	private Node b;
	
	private int uses;
	
	public Connection(Node a, Node b){
		this.a = a;
		this.b = b;
		
		a.connectionIn.add(this);
		b.connectionOut.add(this);
		
		uses = 1;
	}

	public Node getA() {
		return a;
	}

	public Node getB() {
		return b;
	}
	
	public int getUses(){
		return uses;
	}
	
	public void incrementUses(){
		uses++;
	}
	
}
