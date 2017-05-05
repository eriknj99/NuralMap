import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String in = "";


			
			ArrayList<String> allStrings = new ArrayList<String>();
			
			
			/*allLocs.add("/home/erik/Documents/RandM.txt");
			allLocs.add("/home/erik/Documents/RandM.txt");
			allLocs.add("/home/erik/Documents/RandM.txt");
			allLocs.add("/home/erik/Documents/RandM.txt");
			allLocs.add("/home/erik/Documents/RandM.txt");
			allLocs.add("/home/erik/Documents/RandM.txt");*/

			System.out.println("GenoratngRandStrings...");
			for(int i = 0; i < 100; i++){
				allStrings.add(RandStringGen.makeRandString(20, 100, " "));
			}
			System.out.println("done.");

			ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();

			
			for(int i = 0; i < allStrings.size();i++){
				all.add(getAllWordsFromString(allStrings.get(i), " "));
			}

			
			
			//all.add(out);
			
			NeuralMap m = new NeuralMap();
			
			m.build(all);
			
			MapVisualizer v = new MapVisualizer(m);
			v.renderMap();
			
			System.out.println(m.toString());
			System.out.println("done");
			
		}
		
	
	
	private static ArrayList<String> getAllWords(String location, String seperator) throws IOException{
		ArrayList<String> out = new ArrayList<String>();
		
		String in;
		
		BufferedReader br = new BufferedReader(new FileReader(location));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    in = sb.toString();
		} finally {
		    br.close();
		}
		
		
		String temp = "";
		for(int i = 0; i < in.length(); i++){
			
			if(in.substring(i, i+1).equals(seperator)){
				out.add(temp);
				temp = "";
			}else{
				temp += in.substring(i, i+1);
			}
		}
		
		
		return out;
	}
	
	private static ArrayList<String> getAllWordsFromString(String in, String seperator) throws IOException{
		ArrayList<String> out = new ArrayList<String>();
		
		String temp = "";
		for(int i = 0; i < in.length(); i++){
			
			if(in.substring(i, i+1).equals(seperator)){
				out.add(temp);
				temp = "";
			}else{
				temp += in.substring(i, i+1);
			}
		}
		
		
		return out;
	}

}
