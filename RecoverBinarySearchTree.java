/*
Approach: 
1. Inorder traversal of a BST will always give us a sorted array in ascending order
2. Store the treenodes in an array and find the the two elements that are not sorted
3. At this poin, teh problem becomes swapping the 2 out of order elements in an almost sorted array
4. To do so, start the traversal from right end of the array. The moment you encounter an element that is greater than the ith element, set a new pointer to i-1 element, and traverse till jth element is not smaller than the ith element
5. in the end, swap j+1 and ith element 

Time complexity: O(N)
Space complexity: O(N)
*/
public class RecoverBinarySearchTree {
    TreeNode node1;
    TreeNode node2; 
    TreeNode prevRoot;
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        TreeNode temp = node1;
        node1 = node2;
        node2 = temp;
    }
    
    private void traverse(TreeNode root)
    {
        if(root==null)
            return;
        traverse(root.left);
        if(prevRoot!=null && prevRoot.val>root.val)
        {
            if(node1==null)
                node1 = prevRoot;
            else
                node2 = root;
        }
        prevRoot = root;
        traverse(root.right);
    }
}
