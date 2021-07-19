# Trees-5

## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

## Approach-1

//Time Complexity = O(N)
//Space Complexity = O(1)
//DFS Approach

class Solution {
    public Node connect(Node root) {
        if(root == null) return null; 
        
        dfs(root.left, root.right); 
        return root;
    }
    
    private void dfs(Node left, Node right){
        if(left == null) return; 
        
        left.next = right; 
        dfs(left.left, left.right); 
        dfs(left.right, right.left);
        dfs(right.left, right.right); 
    }
}

## Approach 2

//Time Complexity = O(N)
//Space Complexity = O(1)
//Level Order Traversal

class Solution {
    public Node connect(Node root) {
        if(root == null) return null; 
        
        Node level = root; 
        
        while(level.left != null){    
            Node curr = level;
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

## Approach 3

//Time Complexity = O(N)
//Space Complexity = O(N)
//BFS Approach

class Solution {
    public Node connect(Node root) {
        if(root == null) return null; 
        
        Queue<Node> q = new LinkedList<>(); 
        q.add(root); 
        
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = q.poll(); 
            if(prev.left != null){
                q.add(prev.left);
                q.add(prev.right);
            }
            
            for(int i = 1; i < size; i++){
                Node curr = q.poll();
                prev.next = curr;
                if(curr.left != null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev = curr;
            }
            
            
        }



## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
    TreeNode prev; 
    TreeNode first;
    TreeNode last;
    boolean flag; 
    public void recoverTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;    
        inorder(root);
        
        int temp = first.val;
        first.val = last.val; 
        last.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return; 
        
        inorder(root.left); 
        if(prev != null && prev.val >= root.val){
            if(!flag){
                first = prev; 
                last = root;
                flag = true; 
            }else{
                last = root; 
            }
        }
        
        prev = root;
        inorder(root.right); 
    }
}