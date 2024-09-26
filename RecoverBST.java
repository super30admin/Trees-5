// 99.
//approach - inorder traversal of a bst is increasing in nature. The given tree has 2 elements swapped
//so the resultant inorder traversal breaches increasing order in atmost 2 places
//swap the first element of first pair with last element of 2nd pair to restore bst
//brute force - inorder traversal - store in list - identify the elements - swap them - space O(n)
class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode middle = null;
    TreeNode last = null;
    
    public void recoverTree(TreeNode root) {
        //iterativeApproach(root);
        recursiveApproach(root);
        if(last != null)
        {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
            return;
        }
        int temp = first.val;
        first.val = middle.val;
        middle.val = temp;
        return;
    }
    
    //time - O(n) - visit every node in tree
    //space - O(h) - height of tree 
    private void iterativeApproach(TreeNode root) {
        //base
        if(root == null)
        {
            return;
        }
        Stack<TreeNode> support = new Stack<>();
        while(root != null || !support.isEmpty())
        {
            while(root != null) //traverse to the left most node in tree
            {
                support.push(root);
                root = root.left;
            }
            TreeNode top = support.pop();
            if(prev != null && prev.val > top.val) //if ascending order of inorder traversal is violated
            {
                if(first == null) //check if it is 1st breach of ascending order & update 1st,last,mid accordingly
                {
                    first = prev;
                    middle = top;
                }
                else
                {
                    last = top;
                }
            }
            prev = top; //update prev with popped node
            root = top.right; //make root as right of child of popped node to complete the inorder traversal
        }
        return;
    }
    
    private void recursiveApproach(TreeNode root) {
        //base
        if(root == null)
        {
            return;
        }
        //logic
        recursiveApproach(root.left); //traverse left subtree
        if(prev != null && prev.val > root.val) //update 3 pointers incase of breach in ascending order
        {
            if(first == null)
            {
                first = prev;
                middle = root;
            }
            else
            {
                last = root;
            }
        }
        prev = root; //update prev
        recursiveApproach(root.right); //traverse right subtree
    }
}
