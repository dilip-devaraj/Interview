package textJustification;

public class TextJustificationCost {

    private static int calculateCost(int i, String[] words, int[] [] lc, int screenSize){
    	// base case
    	if(i == words.length) {
    		return 0;
    	}
    	for(int j=i+1; j< words.length +1; j++) {
    		return getMin(getWordsBadnessFactor(i,j,  lc,words, screenSize) + calculateCost(j,words, lc, screenSize));
    	}
    }
    
    private static int getMin(int... values) {
    	int min = Integer.MAX_VALUE;
    	for(int i: values){
    		if(i > min){
    			min = i;
    		}
    	}
    }
    
    private static int getWordsBadnessFactor(int i, int j, int[][] lc, String[] words, int screenSize){
    	if(lc[i] [j] != -1) {
    		return lc[i] [j];
    	}
    	int wordsLength=0;
    	for(int messageSubstringIndex =i; messageSubstringIndex<j; messageSubstringIndex++){
    		wordsLength=words[messageSubstringIndex].length() +1;
    	}
    	wordsLength--;
    	
    	if(wordsLength > screenSize) {
    		lc[i] [j] =  Integer.MAX_VALUE;
    	} else {
    		lc[i][j] =  (int) Math.pow((screenSize - wordsLength), 3);
    	}
    	
    	return lc[i] [j];
    }
    
	private static int getTextJustificationCost(String message,int lc [] [] , int screenSize){
		String words[] = message.split(" ");
		
		return calculateCost(0, words, lc, screenSize);
	}
	
	public static void main(String[] args){
		String message = "I am Dilip a student at NCSU";
		int screenSize = 5;
		int lc [] [] = new int[message.length()][message.length()];
		for(int i=0;i<message.length();i++)
			for(int j=0;i<message.length();i++)
				lc[i][j] = -1;
		
		System.out.println(getTextJustificationCost(message, lc, screenSize));
	}
}
