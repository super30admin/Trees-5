//Time Complexity O(n)
//Space Complexity O(1)
//Leetcode tested

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        if(root == null) return;

        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        while(root!=null){
            if(root.left == null){
                //print root
                if(prev!=null && prev.val > root.val){
                    if(first == null){
                        first = prev;
                    }
                    second = root;
                }
                prev = root;

                root = root.right;
            }else{
                TreeNode temp = root.left;
                while(temp.right!=null && temp.right!=root){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = root;
                    root = root.left;
                }
                else{
                    temp.right = null;

                    //print root
                    if(prev!=null && prev.val > root.val){
                        if(first == null){
                            first = prev;
                        }
                        second = root;
                    }
                    prev = root;


                    root = root.right;
                }
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}
