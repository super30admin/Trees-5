// Time O(N) and space O(1)
class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Node level = root;
        
        while(level.left!=null){
            Node curr =level;
            while(curr!=null){
                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr =curr.next;
            }
            level = level.left;
        }
        return root;

    }
}

// Time O(N) and space O(1)
class Solution {
    public void recoverTree(TreeNode root) {
        if(root==null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode x =null;
        TreeNode y = null;
        TreeNode prev =null;


        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }

            root = stack.pop();
            if(prev!=null && root.val< prev.val){
                y=root;
                if(x==null) x=prev;
                else break;
            }
            prev =root;
            root = root.right;
        }
        swap(x,y);
        
    }

    public void swap(TreeNode x, TreeNode y){
        int temp= x.val;
        x.val=y.val;
        y.val = temp;
    }
}
