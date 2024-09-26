//DFS approach
//Time Complexity : O(n)
//Space Complexity : O(1). Ignoring the recursive stack
class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        dfs(root.left,root.right);
        return root;
    }
    public void dfs(Node left, Node right){
        if(left==null){
            return;
        }
        //assign the next of left to right at every level
        left.next = right;
        //each time these three should be assigned
        dfs(left.left,left.right);
        dfs(left.right,right.left);
        dfs(right.left,right.right);
    }
}
//constant space approach
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node level = root;
        //move level by level
        while(level.left!=null){
            Node cur = level;
            while(cur != null){
                //assign left next to right node
                cur.left.next = cur.right;
                //moving from left subtree to right subtree nodes in the same level
                if(cur.next!=null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;//move to next node in the same level
            }
            //move to next level
            level = level.left;
        }
        return root;
    }
}
//BFS approach
//Time Complexity : O(n)
//Space Complexity : O(n/2) ~ O(n)
class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            //use a prev node
            Node prev = q.poll();
            //add its children to queue
            if(prev.left!=null){
                q.add(prev.left);
                q.add(prev.right);//since perfect BT no need to check the condition for right
            }
            //add the cur, since prev is already captured, start iterating from 1
            for(int i=1;i<size;i++){
                Node cur = q.poll();
                 //add its children to queue
                if(cur.left!=null ){
                    q.add(cur.left);
                    q.add(cur.right);
                }
                //connect the prev and cur node
                prev.next = cur;
                //for level greater than 1. i,e connecting children of diffrent parent nodes in the same level
                prev = cur;
            }
            
        }
        return root;
    }
}