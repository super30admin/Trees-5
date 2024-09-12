class Solution {
    public Node connect(Node root) {
        if(root == null) return null; //base case where if root is null, we simply return null
        Node level = root; // we take a variable of type Node with name level and give it the root
        Node curr = root; // we take a variable of type Node with name curr and give it the root
        while(level.left != null) { //if the left of level is not null
            while(curr != null) { //if the curr is not null
                curr.left.next = curr.right; // we take the value of curr left next to curr right
                if(curr.next != null) { // if the curr next value is not null
                    curr.right.next = curr.next.left; // we take the value of curr right next to curr next left
                }
                curr = curr.next; //this is the case where curr.next is null, we the value of curr next to curr
            }
            level = level.left;// if curr is null, level left value is bought to level
            curr = level; // the value of curr becomes the value of level
        }
        return root; // in the end, we return root
    }
}
//tc and sc - O(n) and O(1)