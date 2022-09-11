/*
Brute Force:
1. We do an inorder traversal and put everything in a list
2. Two cases of swap:
 * if the nodes are adjacent
    there would be only one breach
 * if the nodes are in different subtress
    there would be two breaches
3. Have two values first and second     
3. Have boolean flag to identify if it's the first breach or the second breach
4. For first breach update first and second with previous and current and set flag to true
5. for second breach only update the second value with current
6. Swap those nodes
*/


/*
Do we need to maintain the array?
We can follow the same approach we did for validate BST
1. compare previous node with current node and also keep track of if it's the first breach or second.
Time: O(n)
Space: O(h)

*/
public class RecoverBST {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean isFirstBreach;
    
    public void recoverTree(TreeNode root) {
       if(root == null)
           return;
        inorder(root);
        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    
    public void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        //validate BST condition    
        if(prev!= null && prev.val > root.val)    
        {
            if(!isFirstBreach)
            {
                isFirstBreach=true;
                first = prev;
                second = root;
            }
            else{
                second = root;
            }
            
        } 
        prev = root;
        inorder(root.right);
    }
}
