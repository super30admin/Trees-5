/*
Approach: 
1. Inorder traversal of a BST will always give us a sorted array in ascending order
2. While traversing through the tree, keep a track of the previous node. 
3. At every step, compare prev node with current node. 
4. If prev node's value is greater than current node's that is the 1st breach, store the value in a new node
5. Important, you might or might not find the next breach. For example:

            3
            /\
           /  \
          1    4
              /
             /
            2
Traversal would be [1,3,2,4], the breach will only be seen once. 
** Hence it is important to store the next node in node2 in step 4. 
If there is next breach, node2's value will be replaced. Otherwise node2 is node1's next node in the inorder traversal.

** Also, for the first breach, we need to store the prev node, and for the second breach, we need to store the current node and not the previous. 
6. Using the 'secondBreach' boolean, we can come out of the recursion if node's value is replaced the second time
*/
public class RecoverBinarySearchTreeWithoutArray {
    TreeNode node1;
    TreeNode node2; 
    TreeNode prevRoot;
    boolean secondBreach = false; 
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    
    private void traverse(TreeNode root)
    {
        if(root==null || secondBreach)
            return;
        traverse(root.left);
        if(prevRoot!=null && prevRoot.val>root.val)
        {
            if(node1==null)
            {
                node1 = prevRoot;
            }
            if(node2!=null)
                secondBreach = true;
            node2 = root;
        }
        prevRoot = root;
        traverse(root.right);
    }
}
