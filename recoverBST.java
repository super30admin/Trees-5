/*
Problem: https://leetcode.com/problems/recover-binary-search-tree/

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Approach 1: Brute force - inorder traversal. This ideally should be sorted so we can traverse the list to find nodes that are not in sorted order.
// TC: O(n)
// SC: O(n + h) -> h for recursive stack space, n -> for storing nodes in list
class Solution {
    List<TreeNode> nodes = null;
    TreeNode firstElement;
    TreeNode secondElement;
    
    public void recoverTree(TreeNode root) {
        nodes = new ArrayList<>();
        firstElement = null;
        secondElement = null;
        inorder(root);
        findSwappedNodes();
        recoverTree();
    }
    
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        nodes.add(root);
        inorder(root.right);
    }
    
    private void findSwappedNodes() {
        TreeNode prev = null;
        TreeNode cur = null;
        int i = 1;
        
        while (i < nodes.size()) {
            prev = nodes.get(i-1);
            cur = nodes.get(i);
            
            if (cur.val < prev.val) {
            	// When the first mismatch is found, prev element is the incorrect element.
            	// When the second mismatch is found, cur element is the incorrect element.
                if (firstElement == null) {
                    firstElement = prev;
                }
                secondElement = cur;
            }
            ++i;
        }
    }
    
    private void recoverTree() {
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
}

// Approach 2: Using recursion
// Prev always points to the prev element in sorted order if all elements were added to a collection
// TC: O(n)
// SC: O(h) for recursive stack space
class Solution {
    TreeNode firstElement;
    TreeNode secondElement;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        firstElement = null;
        secondElement = null;
        prev = null;
        
        inorder(root);
        swap(firstElement, secondElement);
    }
    
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (firstElement == null) {
                firstElement = prev;
            }
            // First is always prev and second is either cur / root in all approaches.
            // Look at intuition for why we always set secondElement to root
            secondElement = root;
        }
        prev = root;
        inorder(root.right);
    }
    
    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

// Approach 3: recursion with early return
class Solution {
    TreeNode firstElement;
    TreeNode secondElement;
    TreeNode prev;
    boolean flag = false;
    
    public void recoverTree(TreeNode root) {
        firstElement = null;
        secondElement = null;
        prev = null;
        
        inorder(root);
        swap(firstElement, secondElement);
    }
    
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (firstElement == null) {
                firstElement = prev;
                secondElement = root;
                flag = true;
            } else {
                // First is always prev and second is either cur / root in all approaches.
                secondElement = root;
                flag = false;
            }
        }
        prev = root;
        if (!(flag == false && firstElement != null && secondElement != null))
            inorder(root.right);
    }
    
    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

// Approach 4: Iteration using stack to simulate what happens during recursion
// TC: O(n)
// SC: O(h) for the stack we created
class Solution {
    Stack<TreeNode> st = null;
    TreeNode prev = null;
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    
    public void recoverTree(TreeNode root) {
        
        if (root == null)
            return;
        
        st = new Stack<>();
        prev = null;
        
        while (!st.isEmpty() || root != null) {
            
            // The next 4 lines is equivalent to inorder(root.left) in the recursive version
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            // This simulates the case where we hit root == null in the recursion version and simply return. So root will be set to the top of the stack
            root = st.pop();
            if (prev != null && prev.val > root.val) {
                if (firstElement == null) {
                    firstElement = prev;
                }
                secondElement = root;
            }
            prev = root;
            // Equivalent to inorder(root.right);
            root = root.right;
        }
        
        // swap
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
}
