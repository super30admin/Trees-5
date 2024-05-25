## Problem3 Morris Inorder Traversal (https://leetcode.com/problems/binary-tree-inorder-traversal/)

# Approach
# set curr = root. Using predecessor of every element find the next element.
# Traverse till the nodes, use predecessor connection to go back to above levels. 
# Once visited, remove the used predecessor connections


# Time Complexity: O(n*h) = Average time complexity = O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        curr = root

        while(curr != None):
            if (curr.left == None):
                res.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while(pre.right != None and pre.right != curr):
                    pre = pre.right
                if (pre.right == None):
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    res.append(curr.val)
                    curr = curr.right
        return res