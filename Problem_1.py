"""
Problem1 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]


        1

      /

    3

      \

        2

Output: [3,1,null,null,2]


        3

      /

    1

      \

        2
Example 2:

Input: [3,1,4,null,null,2]


          3

        / \

      1   4

        /

      2

Output: [2,1,4,null,null,3]


        2

      / \

    1   4

       /

     3
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
        Time Complexity: O(N)
        Space Complexity : O(H)
        """
        self.first, self.second, self.prev = None, None, None
        self.flag = False
        def inorder(root):
            # Base Condition
            if root == None: return
            
            # Logic
            inorder(root.left)
            if self.prev and self.prev.val > root.val:
                # if it is the first breach then stor the prev in first, root in second and change the flag to True
                if not self.flag:
                    self.flag = True
                    self.first = self.prev
                    self.second = root     
                else:
                    # else it is the second breach then only change the seconf to curr root
                    self.second  = root
                
            self.prev = root
            inorder(root.right)
            
        inorder(root)
        self.swap_TreeNode(self.first, self.second )
        
        return root
        
        
    def swap_TreeNode(self, node_1, node_2):
        """
        Helper function to swap the values of two nodes
        """
        temp = node_1.val
        node_1.val = node_2.val
        node_2.val = temp
        

# Approach - 2

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        Time Complexity: O(N)
        Space Complexity : O(H)
        """
        first, second, prev = None, None, None
        flag = False
        
        stack = []
        
        while root or stack:
            
            while root:
                stack.append(root)
                root = root.left
                
            curr = stack.pop()
            
            if prev and prev.val > curr.val:
                if not flag:
                    flag = True
                    first = prev
                    second = curr
                else:
                    second = curr
            prev = curr
                
            root = curr.right
            
        self.swap_TreeNode(first, second)
        
        return root
        
        
    def swap_TreeNode(self, node_1, node_2):
        """
        Helper function to swap the values of two nodes
        """
        temp = node_1.val
        node_1.val = node_2.val
        node_2.val = temp
        