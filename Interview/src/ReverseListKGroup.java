public class ReverseListKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part, 
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group: 
				ListNode tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed list 
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct part
			}
			head = curr;
		}
		return head;
	}

	public static void main(String[] args) {
		ReverseListKGroup rLKG = new ReverseListKGroup();
		ListNode head = new ListNode();
		head.data = 1;
		ListNode nextNode;
		ListNode prevNode = head;
		int i=2;

		while(i <= 5) {
			nextNode = new ListNode();
			nextNode.data = i;
			prevNode.next = nextNode;
			prevNode = prevNode.next;
			i++;
		}

		nextNode = head;
		while(nextNode !=null) {
			System.out.println(nextNode.data);
			nextNode = nextNode.next;
		}
		System.out.println();

		head = rLKG.reverseKGroup(head, 2);
		nextNode = head;
		while(nextNode !=null) {
			System.out.println(nextNode.data);
			nextNode = nextNode.next;
		}
		
		System.out.println();
		System.out.println( -2 >> 1);
		System.out.println( -2 >>> 1);
	}
}