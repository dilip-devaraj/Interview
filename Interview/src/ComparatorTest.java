import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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

	Integer a[] = new Integer[]{1,2,3};
	List<Integer> listInt = new ArrayList<>(Arrays.asList(a));
	
	listInt.toArray(a);
	System.out.println(Arrays.toString(a));
	
	System.out.println(Integer.MAX_VALUE);
	
	Iterator<Integer> it = listInt.iterator();
	
	Stack<Character> st = new Stack<>();
	}
}