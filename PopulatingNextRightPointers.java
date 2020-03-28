// Time Complexity : O(n) n--> no. of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 1: BFS using iterative approach
// The nodes need to be processed level by level. Normally in BFS approach, we keep a queue for parsing each level.
// In this approach, we can save space by using the next pointer instead of storing each node in a level in queue.
// An additional reference pointer will keep track of level.

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
/*
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Node levelPointer = root;
        
        while(levelPointer != null) {
            Node cursor = levelPointer;
            while( cursor != null) {
                if(cursor.left != null) {
                    cursor.left.next = cursor.right;
                    if(cursor.next != null) {
                        cursor.right.next = cursor.next.left;
                    }
                }
                cursor = cursor.next;
            }
            levelPointer = levelPointer.left;
        }
        return root;
    }
}
*/

// Time Complexity : O(n) n--> no. of nodes
// Space Complexity : O(n) recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 1: DFS using recursive approach
// In recursive approach, we use similar logic as iterative approach. The only difference is that first next assignments will be done considering left child and then right child recursively.

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

