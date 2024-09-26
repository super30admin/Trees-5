//TC - O(N)
//SC - O(1)
class Solution1 {
	public Node connect(Node root) {
		if (root == null)
			return null;
		Node level = root;
		while (level.left != null) // Iterate on depth
		{
			Node curr = level;
			while (curr != null) // Iterate on level
			{
				curr.left.next = curr.right;
				if (curr.next != null) {
					curr.right.next = curr.next.left;
				}
				curr = curr.next;
			}
			level = level.left;
		}
		return root;
	}
}
