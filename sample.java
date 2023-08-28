//Problem 1: Populating next right pointers in each node
// Time Complexity : O(n) Best case
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Queue, Linkedlist, Dfs, enhanced DFS. 4 ways to tackle this. if cur node is not null, perform operations on cur node, move cur.next=cur.parent.right.
class Solution {
    public Node connect(Node root) {
        //bfs
        // Queue<Node> q= new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()){
        //     int size=q.size();
        //     for(int i=0;i<size;i++){
        //         Node cur=q.poll();
        //         if(i!=size-1){
        //             cur.next=q.peek();
        //         }
        //         if(cur!=null){
        //             q.add(cur.left);
        //             q.add(cur.right);
        //         }
                    
        //     }
        // }
        // return root;

        // Node level=root;
        // while(level.left!=null){
        //     Node cur=level;
        //     while(cur!=null){
        //         cur.left.next=cur.right;
        //         if(cur.next!=null){
        //             cur.right.next=cur.next.left;
        //         }
        //         cur=cur.next;
        //     }
        //     level=level.left;
        // }
        // return root;

        //dfs solution
        // dfs(root);
        // return root;

        //enhanced dfs
        dfs1(root.left,root.right);
        return root;
    }
    //O(n) O(h)
    private void dfs(Node root){
        //base
        if(root.left==null) return;
        //logic
        root.left.next=root.right;
        if(root.next!=null){
            root.right.next=root.next.left;
        }

        dfs(root.left);
        dfs(root.right);
    }

    //O(n) O(h)
    private void dfs1(Node left, Node right){
        //base
        if(left==null) return;
        //logic
        left.next=right;
        dfs1(left.left,left.right);
        dfs1(left.right,right.left);
        dfs1(right.left, right.right);

    }

}


//Problem 2: Recover BST
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//check for first and second node that dont follow inorder BST rules, that is sorted array. when u find it, swap it.
class Solution {
    TreeNode prev,first,second;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    private void inorder(TreeNode root){
        //base
        if(root==null) return;
        //logic

        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            if(first==null){
                first=prev;
                second=root; 
}//when they are neighbors, seocnd breach wont happen, hence second
            else
                second=root;
        }
        prev=root;
        inorder(root.right);
    }
}