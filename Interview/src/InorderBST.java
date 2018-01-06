
public class InorderBST {
	private BinaryTreeNode root;
	
	void printInorder(BinaryTreeNode node) {
		if(node == null) return;
		if(node.left!=null) {
			printInorder(node.left);
		}
		System.out.println(node.data);
		if(node.right !=null) {
			printInorder(node.right);
		}
	}
	
	public static void main(String[] args) {
		InorderBST bst = new InorderBST();
		bst.root = new BinaryTreeNode(5);
		bst.root.left = new BinaryTreeNode(2);
		bst.root.right = new BinaryTreeNode(10);
		bst.root.left.right = new BinaryTreeNode(4);

		bst.printInorder(bst.root);
	}
}
