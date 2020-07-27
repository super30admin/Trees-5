// Approach 1: Without using extra space
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root;
        while(level.left != null){  // iterating on depth of treee
            Node curr = level;
            while(curr != null){ // iterate on a level
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }

            level = level.left;

        }
        return root;
    }
}

// Approach 2: With extra space
// Time Complexity: O(n)
// Space Complexity: O(n/2) where n is the number of leaves in the tree
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0 ; i < size ; i++){
            Node curr = q.poll();
            if(i != size - 1){
                Node nextNode = q.peek();
                curr.next = nextNode;
            }
            if(curr.left != null){
                q.add(curr.left);
                q.add(curr.right);
            }
        }
    }
    return root;
}
