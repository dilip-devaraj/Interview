import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ComparatorTest implements Comparator<Integer>{
	
	@Override
	public int compare(Integer a, Integer b){
		return a-b;
		// return b-a;
	}


	public static void main(String[] args){
	// Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
	Queue<Integer> q = new PriorityQueue<>(new ComparatorTest());
	
	q.offer(2);
	q.offer(1);
	q.offer(3);

	while(! q.isEmpty()){
		System.out.println(q.poll());
	}
	
	}


}