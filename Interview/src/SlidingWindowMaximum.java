import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	static int[] getMaxWindow(int[] a, int w){
		if(a.length == 0) {
			return a;
		}
		
		int[] maxs = new int[a.length -w  +1];
		int maxCount= 0;
		// deque of size w storing index, and the corresponding values are in decreasing order
		Deque<Integer> dq = new LinkedList<Integer>();

		// add first w elements to deque
		for(int i=0; i<w; i++){
			//1) check if deque elements is less than a[i]
			while(!dq.isEmpty() && a[dq.peekLast()] < a[i]){
				dq.pollLast();
			}
			// 2) add a[i] elem
			dq.offerLast(i);
		}

/*
		// print deque
		Iterator<Integer> it = dq.iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
*/
		
		// add remaining elements
		for(int i=w; i<a.length; i++){
			// 1) add maxElement
			maxs[maxCount] = dq.peekFirst();
			maxCount++;
			// 2) check if first elem in deque is within window range
			if(!dq.isEmpty() && dq.peekFirst() < i-w+1){
				dq.pollFirst();
			}
			// 3) check if deque elements is less than a[i]
			while(!dq.isEmpty() && a[dq.peekLast()] < a[i]){
				dq.pollLast();
			}
			// 4) add a[i] element
			dq.offerLast(i);
		}

		maxs[maxCount] = dq.pollFirst();
		
		int[] maxValues = new int[maxs.length];
		for(int i=0; i<= maxCount; i++) {
			maxValues[i] = a[maxs[i]];
		}
		return maxValues;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1};
		int[] maxValues = getMaxWindow(a, 1);
		System.out.print(maxValues);
	}
}
