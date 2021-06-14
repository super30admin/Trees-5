

class PopulatingNextRightPointers {
    //Time: O(n)
    //Space: O(1)
    //Did itrun successfully on leetcode: yes
    public Node connect(Node root) {
        //if root is null
        if(root==null) return root;
        //initiate level
        Node level = root;
        //until we reach end of level
        while(level.left!=null){
            //get left most node of current level
            Node curr = level;
            //while curr node is not null
            while(curr!=null){
                //point next of left child of curr node to right child of curr
                curr.left.next = curr.right;
                //if next node of curr exists
                if(curr.next!=null){
                    //point next of right child of curr to left child of next node of curr
                    curr.right.next = curr.next.left;
                }
                //move curr to right
                curr = curr.next;
            }
            //if no more right node for curr, move to next level
            level = level.left;
        }
        return root;
    }

}


















