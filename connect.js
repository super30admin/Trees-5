/**
 * @param {_Node} root
 * @return {_Node}
 * 116. Populating Next Right Pointers in Each Node
Intuition:
We traverse the tree level by level using already established 'next' pointers, starting from the root and always moving down the leftmost path (since it’s a perfect binary tree).
At each node, we connect it's left child to its right child, and if a neighbor exists (`curr.next`), we connect its right child to that neighbor’s left child.
By doing this level by level without extra space, all nodes get linked horizontally using constant space.
T.C: O(N)
S.C: O(1)
 */
var connect = function (root) {
    if (!root) return root;
    let level = root;
    while (level.left) {
        let curr = level;
        while (curr) {
            if (curr.next) {
                curr.right.next = curr.next.left;
            }
            curr.left.next = curr.right;
            curr = curr.next;
        }
        level = level.left;
    }
    return root;
};
