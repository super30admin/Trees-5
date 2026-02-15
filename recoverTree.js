/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
Intuition: 
We perform an **inorder traversal**, which should produce a sorted sequence in a valid Binary Search Tree.
If two nodes were swapped, the inorder order will have one or two “inversions” (where a previous value is greater than the current one).
We detect those misplaced nodes during traversal (`first` and `second`) and finally swap their values to restore the BST without changing the tree structure.
T.C: O(N)
S.C: O(1)
 */
var recoverTree = function (root) {
    let prev, first, second;
    const dfsHelper = (root) => {
        // base
        if (!root) return;

        // action
        dfsHelper(root.left);

        if (prev && prev.val >= root.val) {
            // first breach
            if (!first) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;
        dfsHelper(root.right);
    }

    dfsHelper(root);

    [first, second] = [second, first];
    return root;
};