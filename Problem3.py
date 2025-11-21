"""
TC: O(N) {Each node is visited a constant number of times using threaded  
           links in the Morris traversal, yielding linear total work.}
SC: O(1) {Traversal uses no stack or recursion; only pointer rewiring  
           is performed, achieving constant auxiliary space.}

Approach:
We must return the inorder traversal of a binary tree without using recursion  
or an explicit stack. Morris Traversal enables this by temporarily modifying  
the tree’s structure through “threaded” connections, allowing us to return  
to parent nodes without a call stack.

The core idea:
For each node, we dynamically find its inorder predecessor:
    1. If the current node has no left child, record its value and move right.
    2. If a left child exists, locate the rightmost node in that left subtree  
       (the inorder predecessor).  
       - If the predecessor’s right pointer is null, create a temporary thread  
         pointing back to the current node and move left.  
       - If the thread already exists, remove it, record the current node,  
         and then move right.

Steps:
1. Start with `curr = root` and iterate while `curr` is not None.
2. If no left child exists, append `curr.val` and move to `curr.right`.
3. Otherwise:
       - Walk down to `pred`, the inorder predecessor.
       - If `pred.right` is null, set `pred.right = curr` and move left.
       - If `pred.right` is already pointing to `curr`, remove the thread,  
         append `curr.val`, and move right.
4. Continue until the entire tree is exhausted.
5. Return the collected inorder list.

Morris traversal achieves full inorder traversal without recursion,  
without a stack, and without additional memory—making it optimal in space  
while maintaining linear time behavior.

This solution ran successfully on Leetcode.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        arr = []

        curr = root

        while curr:
            if curr.left:
                pred = curr.left

                while pred.right and pred.right != curr:
                    pred = pred.right
                
                if not pred.right:
                    pred.right = curr
                    curr = curr.left
                else:
                    pred.right = None
                    arr.append(curr.val)
                    curr = curr.right
            else:
                arr.append(curr.val)
                curr = curr.right
                
        return arr