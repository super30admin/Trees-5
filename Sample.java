// Problem -1:

/**
Iterative solution using stack. Use pointers to save the nodes where the breach of inorder traversal is happeneing. In the end swap those two nodes. Two nodes because it is given that Two elements of the BST are swapped by mistake.
TC = O(n) number of nodes in the tree
SC = O(h) stack spack or width of the tree
*/
class Solution {
    TreeNode prev, first, mid, last;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        int temp = 0;
        inorder(root);
        if(last != null && first != null){ // correct the mistakenly swapped values
             temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else if(first != null){
             temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
        
    }
    
    private void inorder(TreeNode root){
        
        Stack<TreeNode> s = new Stack();
        
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            // check if the cur node is breaching the inorder traversal rule of bst
            if(prev != null && root.val < prev.val){
                if(!flag){
                    flag = true; // indicating a breach is found
                    first = prev; mid = root;
                }else{
                    last = root;
                }
            }
            prev = root;
            root = root.right;
        }
    }
}
class Solution {
    TreeNode prev, first, mid, last;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        int temp = 0;
        inorder(root);
        if(last != null && first != null){ // correct the mistakenly swapped values
             temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else if(first != null){
             temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
        
    }
    
    private void inorder(TreeNode root){
        
       if(root == null) return;
        inorder(root.left);
            // check if the cur node is breaching the inorder traversal rule of bst
            if(prev != null && root.val < prev.val){
                if(!flag){
                    flag = true; // indicating a breach is found
                    first = prev; mid = root;
                }else{
                    last = root;
                }
            }
            prev = root;
            inorder( root.right);
    }
}

Problem-2: 

/**
Iterative solution without using extra space. adjusting next pointers of child nodes of a particular level and then move to the next level and follow the same procedure. 
TC = O(n) where n is the num of nodes in the tree
SC = O(1)
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null) return root;
        
        Node level = root; // represents the current level that is being iterated or used to switch levels
        
        while(level.left != null){
            Node cur = level; // cur pointer will iterate over the nodes of a particular level and adjust the next pointers 
            
            while(cur != null){
                cur.left.next = cur.right; // parent adjusting its children next pointers
                if(cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next; // going to the next node of the same level to adjust pointers
            }
            level = level.left; // moving to the next level. Using only left pointer because it is a perfect binary tree
        }
        return root;
    }
}

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0; i < size; i++){
                Node cur = q.poll();
                if(i < size-1){
                    cur.next = q.peek();
                }
                if(cur.left != null){q.add(cur.left);}
                if(cur.right != null){q.add(cur.right);}
            }
        }
        return root;
    }
}
