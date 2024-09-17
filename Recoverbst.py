"""
## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

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

TIME- O(N)
SPACE- O(N)
"""
#recursion
class Solution:
    def recoverBST(self,root):
        if root == None:
            return
        self.prev= None
        self.first = None
        self.mid = None
        self.last = None

        self.inorder(root)

        if self.first != None and self.last != None:
            self.first, self.last = self.last, self.first

        elif self.first != None and self.mid != None:
            self.first, self.mid = self.mid, self.first

    def inorder(self,root):
        #base
        if root == None:
            return None
        #logic
        self.inorder(root.left)
        if self.prev.val > self.root.val and self.prev != None:
            if self.first == None:
                self.first = self.prev
                self.mid = root
            else:
                self.last=root
        self.prev=root

        self.inorder(root.right)



#iterative
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return

        self.first = None
        self.mid = None
        self.last = None
        self.prev = None

        self.inorder(root)

        if self.last != None:  # swap
            self.first.val, self.last.val = self.last.val, self.first.val

        else:  # swap
            self.first.val, self.mid.val = self.mid.val, self.first.val

    def inorder(self, root):
        stack = []
        while root != None or len(stack) != 0:
            while root != None:    # root.left
                stack.append(root)
                root = root.left

            root = stack.pop()

            if self.prev != None and self.prev.val > root.val:
                if self.first == None:
                    self.first = self.prev
                    self.mid = root
                else:
                    self.last = root
            self.prev = root
            root = root.right





