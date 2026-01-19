// Time complexity Of solution is  O(N) Number od nodes worst case we will travsal all nodes 
// Space Complexity : O(N) 
//
public class Solution {

  public IList<int> arr = new List<int>();
          TreeNode curr ;
    public IList<int> InorderTraversal(TreeNode root) {
            curr=root;

        while(curr!=null){
            if(curr.left == null){
                arr.Add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode Ip = Find(curr.left); // find precessdor node
                if(Ip.right == null){
                    Ip.right = curr;
                    curr = curr.left;
                }else{
                    Ip.right = null;
                    arr.Add(curr.val);
                    curr = curr.right;
                }
            }
        }
       return arr;
    }


    public TreeNode Find(TreeNode root){
         TreeNode Ip = root;
         while(Ip.right!=null && Ip.right!=curr){
            Ip = Ip.right;
         }

         return Ip;
    }
}