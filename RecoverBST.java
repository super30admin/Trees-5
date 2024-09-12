//recursive solution
//Time: O(n), beacuase we are traversing through each element
//Space: O(h), h is the height of the tree as it will be the size of the recursive stack

class Solution {
    
    //creating first and second nodes that represent the first and second nodes in the tree that were swapped by mistake
    TreeNode first;
    TreeNode second;
    
    //we will use the prev and root node to traverse through the entire tree
    //in our inorder traversal, the nodes are traversed in ascending order and thus prev will point to the node reached by root before it
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        //null case check
        if(root == null) return;
        
        //calling the inorder traversal on the first node
        inorder(root);
        
        //swapping the two values to get a balanced binary tree
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root) {
        
        //null case check
        if(root == null) return;
        
        //calling the inorder traversal recursively on the left node
        inorder(root.left);
        
        //running this when the root is already on the second node i.e. the prev node is not null
        //as well as making sure that we have reached a breach where values of prev >= root
        if(prev != null && prev.val >= root.val) {
            //then we check if first is null, if yes then this would mean, this is the first breach that we have encountered
            if(first == null) {
                //we get the prev and root values and store them in first and second
                first = prev;
                second = root;
            }
            //if first is not null, this would mean this is the second time a breach has happened
            else {
                //therefore we only update the second node to root
                second = root;
            }
        }
        //we move the prev node forward
        prev = root;
        
        //we finally call the inorder traversal on the right node
        inorder(root.right);
    }
}