# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We walk through the tree using Morris traversal, without stack or recursion.
# If a node has no left, we print it and go right; else we link the predecessor to current.
# When that link brings us back, we remove it and print the node.

class Solution:
    def morrisInorderTraversal(self, root):
        curr = root
        while curr is not None:
            if curr.left is None:
                print(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right is not None and pre.right != curr:
                    pre = pre.right

                if pre.right is None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    print(curr.val)
                    curr = curr.right
