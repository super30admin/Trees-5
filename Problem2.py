"""
TC: O(N) {We perform a complete inorder traversal of the tree.  
           Each node is visited exactly once, and all comparisons  
           and pointer updates occur in O(1) time.}
SC: O(H) {The recursion stack grows only along the tree height.  
           For a balanced BST this is O(log N); in the worst case, O(N).}

Approach:
We are asked to restore a Binary Search Tree in which exactly two nodes  
have had their values swapped. Since an inorder traversal of a valid BST  
must yield a strictly increasing sequence, any violation of this order  
reveals a “breach” caused by the swapped nodes.

The core idea:
Traverse the tree in inorder while tracking:
    1. `prev`  – the previously visited node,
    2. `first` – the first node where the BST order breaks,
    3. `second` – the node later encountered that violates ordering again.  
Once both nodes are identified, we simply swap their values.

Steps:
1. Initialize `prev = None`, `first = None`, `second = None`.
2. Perform an inorder DFS:
       - When `prev.val >= node.val`, a breach is detected.
       - If `first` is still None, record `first = prev` and `second = node`.
       - Otherwise, update `second = node` for the second breach.
3. After DFS completes, swap the values of `first` and `second`.
4. The BST is now fully restored without altering structure.

This inorder-detection technique cleanly isolates the two incorrect nodes  
while preserving O(1) extra data usage and leverages the sorted property  
of BST traversal to perform the recovery efficiently.

This problem ran successfully on Leetcode.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #do the in order traversal,keep track of the first and second breach, swap them

        def dfs(node):
            nonlocal prev, first, second
            #base
            if not node:
                return
            
            dfs(node.left)
            if prev and prev.val >= node.val: #there's a breach
                if first:
                    #second breach
                    second = node
                    return
                else:
                    first = prev
                    second = node
            prev = node
            dfs(node.right)
        
        prev = root
        first, second = None, None
        dfs(root)
        first.val, second.val = second.val, first.val
        
        
        
        
