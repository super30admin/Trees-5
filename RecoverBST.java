// TC-O(N) SC-O(h)
public class RecoverBST {
    TreeNode prev=null;
    TreeNode first=null;
    TreeNode second=null;
    public void recoverTree(TreeNode root) {
        if(root==null)return;
        inorderRecoverBST(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    public void inorderRecoverBST(TreeNode root){
        //base
        if(root==null)return;
        //logic
        inorderRecoverBST(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null)
                first=prev;
            second=root;
        }
        prev=root;
        inorderRecoverBST(root.right);

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



}

/*///using lst TC-O(N) SC-O(N)+O(h)
 int first=-1;
    int second=-1;
    List<TreeNode> lst;
    public void recoverTree(TreeNode root) {
         lst = new ArrayList<>();
        inorderRecoverBST(root);
        for(int i=1;i<lst.size();i++){
            if(lst.get(i).val< lst.get(i-1).val){
               if(first != -1)
                   second=i;
                   else
                   first=i-1;
            }
        }
        int temp;
        if(first!=-1 && second==-1) {
           temp=lst.get(first).val;
           lst.get(first).val=lst.get(first+1).val;
           lst.get(first+1).val=temp;
        }else if(first!=-1 && second!=-1 ){
           temp=lst.get(first).val;
           lst.get(first).val=lst.get(second).val;
           lst.get(second).val=temp;
        }
    }
    public void inorderRecoverBST(TreeNode root){
        //base
        if(root==null) return;
       inorderRecoverBST(root.left);
       lst.add(root);
       inorderRecoverBST(root.right);

    }
 */
