import java.util.Random;

public class RandStringGen {

	
	public static String makeRandString(int wordLength, int numOfWords, String seporator){
		String out = "";
		
		for(int i = 0; i < numOfWords; i++){
			for(int x = 0; x < wordLength; x++){
				out += getRandLetter();
			}
			out += seporator;
		}
	
		return out;
	}
	
	private static char getRandLetter(){
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		return c;
	}
}
