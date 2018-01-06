import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class TopKWordsLexico {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
        	if(count.containsKey(word)){
        		count.put(word,count.get(word)+1);
        	} else{
        		count.put(word,1);
        	}
        }

        Queue<String> heap = new PriorityQueue<String>(
        		new Comparator<String>(){
        			public int compare(String w1, String w2){
        				if(count.get(w1) != count.get(w2)){
        					return count.get(w1) - count.get(w2);
        				} else{
        					return w2.compareTo(w1);
        				}
        			}
        		}
		);

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
    
	public static void main(String[] args) {
		String[] words = new String[] {"the", "day", "is", "sunny", "the", "the", "sunny", "is", "is"};
		TopKWordsLexico topK = new TopKWordsLexico();
		List<String> topKWords = topK.topKFrequent(words, 2);
		
		for(String word: topKWords) {
			System.out.println(word);
		}
	}
}