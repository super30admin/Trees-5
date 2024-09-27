package s30.Trees-5;

public class problem1 {
    public Node connect(Node root) {
        //TC:- O(n)
        //SC:- O(n)
        if(root == null) return root;
        
        Node level = root;
        Node curr = null;

        while(level.left != null){
            curr = level;
            while(curr != null){
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
