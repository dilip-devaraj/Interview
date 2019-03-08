import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KClosestElements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		
        List<Integer> elements = new ArrayList<>();
        for(int i=0; i< arr.length; i++) {
        	elements.add(arr[i]);
        }
		
		// Collections.sort(arr, new DisComparator(x));
	     Collections.sort(elements, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
	     elements = elements.subList(0, k);
	     Collections.sort(elements);
	     return elements;
	}
	
	class DisComparator implements Comparator<Integer>{
		int x;
		DisComparator(int x){
			this.x = x;
		}
		
		@Override
		public int compare(Integer a, Integer b) {
			if(a == b) {
				return 0;
			} else {
				return Math.abs(a -x) - Math.abs(b-x);
			}
		}
	}
	
	public static void main(String[] args) {
		KClosestElements kC = new KClosestElements();
		int[] arr = new int[] {1,2,3,4,5};
		kC.findClosestElements(arr, 4, 3);
	}
}
