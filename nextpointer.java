TC: O(n) - n no.of nodes of a tree
SC: O(n)
successfully run on leetcode


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
    Node head;
    List<List<Node>>result = new ArrayList<>();
    public Node connect(Node root) {
        head = root;
        if(head == null) return null;
        
        helper(head,0);
        for(int j=0;j<result.size();j++){
            List<Node>li = new ArrayList<>();
            li = result.get(j);
            for(int i=0;i<li.size();i++){
                if(i==li.size()-1){
                    li.get(i).next = null;
                }
                else{
                    li.get(i).next = li.get(i+1);
                }
            }
        }
        return head;
    }
    private void helper(Node root,int level){
         //base
        if(root == null) return;
        
        //logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root);
        helper(root.left,level+1);
        helper(root.right,level+1);
        
    }
}