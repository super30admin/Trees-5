# Trees-5

## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

Approached Solution: The solution connects all nodes at the same level in a perfect binary tree. It utilizes a recursive depth-first search (DFS) approach to traverse the tree. Starting from the root, the algorithm connects the left child’s next pointer to the right child. Additionally, if the current node has a next pointer (connecting to another subtree), the right child’s next pointer is connected to the left child of the next node. The recursion continues for both left and right subtrees. This method ensures all connections are established as the recursion unwinds, leveraging the perfect binary tree's structure to achieve constant space complexity apart from the recursion stack.

Time Complexity: O(n) where n is number of nodes in the tree as each node will be visited at least once.

Space Complexity: O(h) where h is the height of the tree due to recursive stack.

Approached Code:

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }

        // Queue<Node> queue = new LinkedList<>();
        // queue.add(root);

        // while(!queue.isEmpty()) {
        //     int size = queue.size();

        //     for(int i = 0; i < size; i++) {
        //         Node curr = queue.poll();
        //         if(i != size - 1) {
        //             curr.next = queue.peek();
        //         }

        //         if(curr.left != null) {
        //             queue.add(curr.left);
        //         }

        //         if(curr.right != null) {
        //             queue.add(curr.right);
        //         }
        //     }
        // }


        // Node level = root;
        // while(level.left != null) {
        //     Node curr = level;

        //     while(curr != null) {
        //         curr.left.next = curr.right;
        //         if(curr.next != null) {
        //             curr.right.next = curr.next.left;
        //         }
        //         curr = curr.next;
        //     }

        //     level = level.left;
        // }



        dfs(root);

        return root;
    }

    private void dfs(Node root) {
        // base
        if(root.left == null){
            return;
        }

        // logic
        root.left.next = root.right;
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}



## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

Approached Solution: The problem involves recovering a binary search tree (BST) in which two nodes have been swapped. To solve this, the algorithm uses an in-order traversal, as in-order traversal of a BST gives a sorted sequence of values. During traversal, the algorithm keeps track of the previous node (prev) and compares it to the current node (root). If the value of prev is greater than or equal to the value of root, it indicates a violation of the BST property. The first violation identifies the first misplaced node (first), while the second violation identifies the second misplaced node (second). After traversal, the values of these two nodes are swapped to restore the BST. A flag is used to track whether the first violation has been encountered, ensuring that only two nodes are identified.

Time Complexity: O(n) where n is number of nodes in the tree as we will do inorder traversal for the whole tree.

Space Complexity: O(h) where h is the height of the tree due to recursive stack.

Approached Code:

/**
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
class Solution {

    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean flag;

    public void recoverTree(TreeNode root) {
        
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void inorder(TreeNode root) {
        // base
        if(root == null) {
            return;
        }

        // logic
        inorder(root.left);

        if(prev != null && prev.val >= root.val) {
            if(!flag) {
                first = prev;
                second = root;
                flag = true;
            } else {
                second = root;
            }
        }

        prev = root;

        inorder(root.right);
    }
}



## Problem3 Morris Inorder Traversal (https://leetcode.com/problems/binary-tree-inorder-traversal/)

Approached Solution: This solution provides three approaches for in-order traversal of a binary tree: recursive, iterative using a stack, and Morris Traversal (space-optimized). The first two methods are commented out. The final implemented approach uses Morris Traversal, which avoids the use of additional space by utilizing the tree's structure. In Morris Traversal, for each node, it checks if there is a left child. If a left child exists, the algorithm finds the inorder predecessor (the rightmost node of the left subtree). A temporary thread (link) is established between the predecessor and the current node to facilitate returning to the current node after traversing the left subtree. If no left child exists or the temporary thread is removed, the node's value is added to the result, and traversal proceeds to the right child.

Time Complexity: O(n) where n is number of nodes in the tree as each node is visited at most twice.

Space Complexity: O(1) as we are not using any auxillary data structure.

Approached Code:

/**
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
class Solution {
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        // this.result = new ArrayList<>();
        // helper(root);
        // return result;



        // Stack<TreeNode> st = new Stack<>();
        // List<Integer> result = new ArrayList<>();

        // while(!st.isEmpty() || root != null) {
        //     while(root != null) {
        //         st.push(root);
        //         root = root.left;
        //     }
        //     root = st.pop();
        //     result.add(root.val);
        //     root = root.right;
        // }

        // return result;



        List<Integer> result = new ArrayList<>();

        while(root != null) {
            if(root.left == null) {
                result.add(root.val);
                root = root.right;
            } else {
                TreeNode pre = root.left;

                while(pre.right != null && pre.right != root) {
                    pre = pre.right;
                }

                if(pre.right == null) {
                    pre.right = root;
                    root = root.left;
                } else {
                    pre.right = null;
                    result.add(root.val);
                    root = root.right;
                }
            }
        }

        return result;

    }

    private void helper(TreeNode root) {
        // base
        if(root == null) {
            return;
        }

        // logic
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}


