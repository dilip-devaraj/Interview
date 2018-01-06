import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class Solution {
	public String longestWord(String[] words) {
		Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b){
				return b-a;
			}
		});

		Map<Integer, Set<String>> lengthWordsMap= new HashMap<>();

		for(String word: words){
			if(lengthWordsMap.containsKey(word.length())){
				lengthWordsMap.get(word.length()).add(word);
			} else{
				Set<String> wordsInBucket = new TreeSet<String>();
				wordsInBucket.add(word);
				lengthWordsMap.put(word.length(), wordsInBucket);
				maxHeap.offer(word.length());

			}
		}

		while(!maxHeap.isEmpty()){
			Integer longestLength = maxHeap.poll();
			// System.out.println(longestLength);

			Set<String> longestWords = lengthWordsMap.get(longestLength);

			for(String word:longestWords){
			//	System.out.println(word);
				boolean foundWord = false;
				if(word.length() == 1) return word;
				for(int i = word.length() -1; i > 0; i--){
					String subString = word.substring(0,i);
			//		System.out.println(subString);
					if(lengthWordsMap.containsKey(subString.length()) && 
							lengthWordsMap.get(subString.length()).contains(subString)){
						foundWord = true;
						continue;
					} else{
						foundWord = false;
						break;
					}
				}
				if(foundWord == true) return word;
			}
		}

		return new String();
	}
	
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		// String[] words = new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		String[] words = new String[] {"ts","e","x","pbhj","opto","xhigy","erikz","pbh",
				"opt","erikzb","eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"};
		
		System.out.println(sol.longestWord(words));
	}
}