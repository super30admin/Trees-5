// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i<size; i++){
                Node temp = q.poll();
                
                if(i==size-1){
                    temp.next = null;
                }
                else{
                    temp.next = q.peek();
                }
                
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        return root;       
    }
}