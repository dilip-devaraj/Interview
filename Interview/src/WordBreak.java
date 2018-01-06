public class WordBreak {
	
	Boolean[][] cache;
	String[] dictWords;

	boolean isWordDiv(String word, String[] words){
		cache = new Boolean[word.length()][word.length()];
		
		for(int i=0; i< word.length(); i++) {
			for(int j=0; j< word.length(); j++) {
				cache[i][j] = null;
			}
		}
		
		dictWords = new String[words.length];
		for(int i=0; i< words.length; i++){
			dictWords[i] = words[i];
		}

		return isWordDiv(word, 0, word.length() -1);
	}

	boolean isWordDiv(String word, int bi, int ei){
		if(bi > ei) return true;

		if(cache[bi][ei] !=null){
			return cache[bi][ei];
		}

		for(int i=bi; i<word.length();i++){
			if(isInDict(word.substring(bi, i+1))){
				cache[bi][i] = true;
				if(isWordDiv(word, i+1, ei)){
					return true;
				}
			} else {
				cache[bi][i] = false;
			}
		}
		return false;
	}

	boolean isInDict(String checkWord){
		for(String word:dictWords){
			if(checkWord.equals(word)){
				return true;
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		String[] dictWords = new String[] {"hello","i","ik", "like","il"};
		WordBreak wb = new WordBreak();
		System.out.println(wb.isWordDiv("ilijik", dictWords));
	}
}