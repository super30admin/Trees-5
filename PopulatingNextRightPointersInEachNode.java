// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: 

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;

        Node current=root;
        while(current.left!=null){
            Node nextLevel= current.left;    
        
        while(current!=null){
            current.left.next=current.right;

            if(current.next==null){
                current.right.next=null;
            }
            else{
                current.right.next= current.next.left;
            }
            current=current.next;
        }
        current=nextLevel;
        }
        return root;
    }
}