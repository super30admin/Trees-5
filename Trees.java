import java.util.*;
public class Trees{
     // time complexity : N
    // space complexity : H
    // any doubts : no
    // did it run on leetcode : yes
    // https://leetcode.com/problems/recover-binary-search-tree/submissions/
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        helper(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;
        return;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != null && root.val < prev.val){
            if(!flag){
                flag = true;
                first = prev;
                last = root;
            }else{
                last = root;
            }
        }
        prev = root;
        helper(root.right);
    }
       // time complexity : N
    // space complexity : 1
    // any doubts : no
    // did it run on leetcode : yes
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
    public Node connect(Node root) {
        Node level = root;
        Node curr = level;
        while(level != null){
            curr = level;
            while(curr != null){
            if(curr.left != null){
                curr.left.next = curr.right;
            }
            if(curr.next != null && curr.right != null){
                curr.right.next = curr.next.left;
            }
            
            curr = curr.next;   
        }
            level = level.left;
        }
        return root;
        
    }
}