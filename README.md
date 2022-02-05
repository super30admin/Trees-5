# Trees-5

## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the 
following definition:

struct Node {

  int val;

  Node *left;

  Node *right;

  Node *next;

}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example:



Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right 
node, just like in Figure B.

Note:

You may only use constant extra space.

Recursive approach is fine, implicit stack space does not count as extra space for this problem.

# Time Complexity = O(n)
# Space Complexity = O(1)

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # if root is None:
        #     return 
        # if root.left is not None:
        #     root.left.next=root.right
        # if root.next is not None and root.right is not None:
        #     root.right.next=root.next.left
        # self.connect(root.left)
        # self.connect(root.right)
        # return root
        if root is None:
            return 
        level=root
        while level.left is not None:
            curr=level
            while curr is not None:
                curr.left.next=curr.right
                if curr.next is not None and curr.right is not None:
                    curr.right.next=curr.next.left
                curr=curr.next
            level=level.left
        return root
        
        
        

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


# Time Complexity = O(n)
# Space Complexity = O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        first,second,prev=None,None,None
        flag=False
        def inorder(root):
            nonlocal first,second,prev,flag
            if root is None:
                return 
            inorder(root.left)
            if prev is not None and prev.val>root.val:
                if flag==False:
                    first=prev
                    second=root
                    flag=True
                else:
                    second=root
            prev=root
            inorder(root.right)
        inorder(root)
        first.val,second.val=second.val,first.val
        """
        Do not return anything, modify root in-place instead.
        """
        