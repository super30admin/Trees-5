#  Time Complexity : O(N) 
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code performs an inorder traversal of a binary tree using Morris Traversal, which avoids recursion and stack usage. It temporarily modifies the tree by linking each node’s inorder predecessor’s right pointer to the current node, allowing the traversal to backtrack efficiently. Once a node’s left subtree is fully explored, the link is removed, the node’s value is added to the result list, and traversal continues to the right subtree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # TC: O(n)  SC: O(1)
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        curr = root
        currLst = []
        while curr is not None:
            if curr.left is None:
                currLst.append(curr.val)
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
                    currLst.append(curr.val)
                    curr = curr.right
        
        return currLst
        