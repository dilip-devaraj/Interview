import java.util.Stack;

public class InOrderBinaryTreeStack {
	private BinaryTreeNode root;

	void printInorder(BinaryTreeNode node) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

		// go all way to left down
		while(node !=null) {
			stack.push(node);
			node = node.left;
		}

		while(! stack.isEmpty()) {
			node = stack.pop();
			// print current node
			System.out.println(node.data);

			// go right node and make that current
			if(node.right != null) {
				node = node.right;

				// goto left most down on current node
				while(node !=null) {
					stack.push(node);
					node = node.left;
				}		
			}
		}
	}

	public static void main(String[] args) {
		InOrderBinaryTreeStack bst = new InOrderBinaryTreeStack();
		bst.root = new BinaryTreeNode(5);
		bst.root.left = new BinaryTreeNode(2);
		bst.root.right = new BinaryTreeNode(10);
		bst.root.left.right = new BinaryTreeNode(4);

		bst.printInorder(bst.root);
	}
}
