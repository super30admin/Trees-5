//Time Complexity: O(N)
//Space Complexity: O(1)

//Morris inorder traversal to get the inorder sequence of the tree without using extra space
//we use the right pointer of the predecessor node to point to the current node
//we then move to the left child and repeat the process until we reach the leftmost node
//once we reach the leftmost node we add it to the result and move to the right child
//if the right pointer of the predecessor node is already pointing to the current node
//we set it to null and add the current node to the result and move to the right child
//this way we can get the inorder sequence of the tree without using extra space

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //Morris inorder traversal
        List<Integer> al=new ArrayList<>();
        TreeNode curr=root,prev;
        while(curr!=null){
            if(curr.left==null){
                al.add(curr.val);
                curr=curr.right;
            }else{
                prev=curr.left;
                while(prev.right!=null&&prev.right!=curr)
                    prev=prev.right;
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }else{
                    prev.right=null;
                    al.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return al;
    }
}