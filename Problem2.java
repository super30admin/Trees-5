// Time Complexity : O(n) 
// Space Complexity : O(1) // Using Morris In order Traversal
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {

    TreeNode prev; 
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {  
       // inOrderRec(root);
      // iterative(root);
      morrisInorder(root);
        //swap first with second
        int temp = second.val;
        second.val = first.val;
        first.val = temp;

    }

    private void inOrderRec(TreeNode node){
        if(node == null) return;
        inOrderRec(node.left);
        // In order
        if(prev !=null && prev.val >= node.val){
            // This one will be counted  as a breach ,because node.val should be greater than prev.val
            if(first == null){ // if its a first breach
            first = node;
            second = prev; // Prev points to the misplaced element
            }else{ // if it is a second breach
            first = node; // node points to the misplaced element
            }
        }
        prev = node;
        inOrderRec(node.right);
    }


    private void iterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()){

            //keep going left
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(prev!=null && prev.val >= node.val){
                if(first == null){ // check if its first breach
                first = node;
                second = prev; // This is pointing to the first misplaced element
                }else{ // check if its second breach
                first = node; // this is pointing to misplaced element
                }
            }

            prev = node;
            node = node.right;
        }

    }


    private void morrisInorder(TreeNode root){
        TreeNode current = root;
        
        while(current != null){
            TreeNode predessor = null;
            if(current.left != null){ // if a node has a left child, then traverse all the way
            predessor = current.left;
            while(predessor.right != null && predessor.right!=current){
                predessor = predessor.right;
            }
            if(predessor.right == null){ // if right is empty , then we need to keep making connection
            predessor.right = current;
            current = current.left;
            } else{ // this means connection already exists , remove connection and move right
            predessor.right = null;
            // in order
            // visit
            if(prev!=null && prev.val >= current.val){
            // There is a breach
            // if this is first breach
                if(first == null){
                    first = current;
                    second = prev;
                }else{
                    first = current;
                }
            }
            prev = current;
            current = current.right;
            }
            }else{
            
            // in order
            // visit
            if(prev!=null && prev.val >= current.val){
            // There is a breach
            // if this is first breach
                if(first == null){
                    first = current;
                    second = prev;
                }else{
                    first = current;
                }
            }
                prev = current;
                current = current.right;
            }
        }
    }





}