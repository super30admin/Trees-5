// Time Complexity - O(N)
// Space Complexity - O(N) 

// Using Queue - Do BFS
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q =new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node curr = q.poll();
                if(i!=size-1) {
                    Node nextNode = q.peek();
                    curr.next = nextNode;
                }
                if(curr.left!=null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}

// Without Queue - use two pointers for iterating through the depth of tree and another for iterating through
// level of the tree

// Time - O(N) || Space - O(1)

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root; // iterating on depth of tree
        while(level.left!=null) {
            Node curr = level;
            while(curr!=null) { // iterate on level
                curr.left.next = curr.right;
                if(curr.next!=null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}