import java.util.Random;

public class LinkedListRandonNode {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	ListNode head;
	Random random;

	public LinkedListRandonNode(ListNode h) {
		head = h;       
		random = new Random();        
	}

	public int getRandom() {

		ListNode c = head;
		int r = c.val;
		for(int i=1;c.next != null;i++){

			c = c.next;
			if(random.nextInt(i + 1) == i) r = c.val; 
		}

		return r;
	}
}