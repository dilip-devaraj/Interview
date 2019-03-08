import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList{
	
	public class ListNode{
		int val;
		ListNode next;
		
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
			public int compare(ListNode l1, ListNode l2){
				return l1.val - l2.val;
			}
		});

		ListNode head = new ListNode(0);
		ListNode p = head;

		for(ListNode list: lists){
			if(list!=null)
				queue.offer(list);
		}    

		while(!queue.isEmpty()){
			ListNode n = queue.poll();
			p.next = n;
			p=p.next;

			if(n.next!=null)
				queue.offer(n.next);
		}    

		return head.next;

	}
	
	public static void main(String[] args) {
		MergeKList ml = new MergeKList();

		ListNode l1 = ml.new ListNode(5);
		l1.next = ml.new ListNode(8);
		
		ListNode l2 = ml.new ListNode(4);
		l2.next = ml.new ListNode(7);
		
		ListNode l3 = ml.new ListNode(6);
		l3.next = ml.new ListNode(9);
		
		ListNode[] lists = new ListNode[] {l1,l2,l3};
		
		ListNode mergedList = ml.mergeKLists(lists);
		
		while(mergedList !=null) {
			System.out.println(mergedList.val);
			mergedList =  mergedList.next;
		}
		
	}
}