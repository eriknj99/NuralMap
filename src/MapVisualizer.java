import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MapVisualizer extends JFrame{

	
	private NeuralMap map;
	
	private ArrayList<Rect> allRects;
	private ArrayList<Line> allLines;
	public MapVisualizer(NeuralMap map) {
		
		this.setBounds(0,0,500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	this.setUndecorated(true);
		
		this.map = map;
		
		allRects = new ArrayList<Rect>();
		allLines = new ArrayList<Line>();
		
	}
	
	public void renderMap(){
		ArrayList<Node> n1 = new ArrayList<Node>();
		ArrayList<Node> n2 = new ArrayList<Node>();

		for(int j = 0; j < map.getNodes().size(); j++){
			
		System.out.println(j + " / " + map.getNodes().size());
		n1 = new ArrayList<Node>();
		n1.add(map.getNodes().get(j));
		
		Point prev = new Point(0,0);
		for(int i = 0; i < n1.size(); i++){
			n2.addAll(n1.get(i).getAllOutNodes());

		//	System.out.println("n1 = " + n1.size());

			for(int x = 0; x < n2.size(); x++){
			//	System.out.println("n2 = " + n2.size())
				allRects.add(new Rect((x * 20) + 10,( i * 20 ) + 10, 10 ,10));
		     	allLines.add(new Line(prev.x,prev.y, (x * 20) + 10,( i * 20 ) + 10));
			}
			prev = new Point((n2.size() * 20) + 10,( i * 20 ) + 10);
			
			 
			n1 = new ArrayList<Node>();
			n1.addAll(n2);
			n2 = new ArrayList<Node>();
		}
		}
		repaint();
	}
	
	public Node getNextNode(){
		
		
		
		return new Node("");
	}
	
	@SuppressWarnings("unchecked")
	public void paint(Graphics g){
		super.paint(g);
		
		for(int i = 0; i < allRects.size(); i++){
			g.drawRect(allRects.get(i).x,allRects.get(i).y,allRects.get(i).w,allRects.get(i).h);
		}
		for(int i = 0; i < allLines.size(); i++){
			g.drawLine(allLines.get(i).x1,allLines.get(i).y1,allLines.get(i).x2,allLines.get(i).y2);
		}
		
		//map.getNodes().get(0).connectionOut.size()
		//What the FUCK should I do now?
	}
	
	
	
	
	
	
}
