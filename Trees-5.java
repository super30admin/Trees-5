//1. Recovering BST
//Time Complexity -> O(h)
//Space Complexity -> O(h)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //Using Recursion
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        swap(first,second);
        // int temp = first.val;
        // first.val = second.val;
        // second.val = temp;
        return;
        
        
    }
    private void swap(TreeNode first,TreeNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val>root.val){
            if(first == null){
                first = prev;
                second = root;
            }
            // if(first!=null){
            //     second = root;
            // }
        }
        prev = root;
        inorder(root.right);


    }
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //Using  iteration
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        iterativeInorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
        
    }

    private void iterativeInorder(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> st = new Stack();
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val >= root.val){
                if(first == null){
                    first = prev;
                    second = root;
                }else{
                    second = root;
                }
            }
            prev = root;
            root = root.right;
        }
    }
}

//2nd Populating right pointer
//Time Complexity -> O(n)
//Space Complexity -> O(h)
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
    //DFS
    public Node connect(Node root) {
        if(root == null) return root;
        dfs(root);
        return root;
        
    }

    private void dfs(Node curr){
        if(curr == null) return;
        if(curr.left == null) return;
        curr.left.next = curr.right;
        if(curr.next!=null){
            curr.right.next = curr.next.left;
        }
        dfs(curr.left);
        dfs(curr.right);
    }
}

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
    //BFS
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ;i<size ;i++){
                Node curr = q.poll();
                if(i != size - 1){
                    curr.next = q.peek();
                }
                if(curr.left!= null){
                   q.add(curr.left);
               }
                if(curr.right!=null){
                    q.add(curr.right);
               }
            }
            
        }
        return root;
        
    }

    
}

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
    //Using BFS but without the queue space
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;
        while(level.left!=null){
            Node curr = level;
            while(curr!=null){
                 curr.left.next = curr.right;
                if(curr.next!=null){
                curr.right.next = curr.next.left;
                
               }
               curr = curr.next;
            }
            
            level = level.left;
        }

        return root;
        
    }

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
    //Using 2nd type DFS
    public Node connect(Node root) {
        if(root == null) return root;
        dfs(root.left,root.right);
        return root;
        
    }

    private void dfs(Node left,Node right){
       //base case
       if(left == null || right == null) return;

       //logic
       left.next = right;
       dfs(left.left,left.right);
       dfs(left.right,right.left);
       dfs(right.left,right.right);

    }

}  
}