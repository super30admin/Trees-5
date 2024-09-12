class Solution {
    TreeNode prev, first, second; // we initialize variables called as root, first, second of the type TreeNode in the global scope
    public void recoverTree(TreeNode root) {
        if(root == null) return; //base case where if the root is null, we simply return
        inorder(root); //we call the method inorder and pass the variable root to it.
        int temp = first.val; // we initialize a temp variable of type integer and store the value of first into temp for swapping
        first.val = second.val; // we store the value of second to the value of first
        second.val = temp; // we bring the value of temp and store that value in the second value.
    }
    private void inorder(TreeNode root) {
        //base
        if(root == null) return; //if root is null, return
        //logic
        if(prev != null && prev.val >= root.val) { //if prev is not null and the value of prev is greater than root value,
            if(first == null) { //here we check if the root is null
                first = prev; //we bring the value of prev to first
                second = root; // we bring the value of root to second
            }
            else { // if first is not null
                second = root; // we only update the second
            }
        }
        prev = root; // if prev is null which it actually is initially, we update its value to the roots value
        inorder(root.right); // we move to the right.
    }
}
//tc and sc - O(n) and O(h)