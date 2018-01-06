import java.util.Iterator;
import java.util.Stack;

public class InOrderBinaryTreeIterator implements Iterator<BinaryTreeNode>{
	Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
	
	InOrderBinaryTreeIterator(BinaryTreeNode node){
		// go all way to left down
		while(node !=null) {
			stack.push(node);
			node = node.left;
		}		
	}

	@Override
	public BinaryTreeNode next() {
		BinaryTreeNode current = stack.pop();
		BinaryTreeNode node = current;

		// go right node and make that current
		if(node.right != null) {
			node = node.right;

			// goto left most down on current node
			while(node !=null) {
				stack.push(node);
				node = node.left;
			}		
		}
		return current;
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(10);
		root.left.right = new BinaryTreeNode(4);

		InOrderBinaryTreeIterator bstIt = new InOrderBinaryTreeIterator(root);

		while(bstIt.hasNext()) {
			BinaryTreeNode n = bstIt.next();
			System.out.println(n.data);
		}
	}
}
