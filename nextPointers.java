// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node cur=root;
        Node left=root;
        while(left.left!=null){
            cur=left;
            while(cur!=null){
                cur.left.next=cur.right;
                if(cur.next!=null){
                    cur.right.next=cur.next.left;
                }  
                cur=cur.next;
            }
            left=left.left;
            
        }
        return root;
    }
}