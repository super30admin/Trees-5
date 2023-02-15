"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

# Time Complexity = O(n)
# Space Complexity = O(1)


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # if root is None:
        #     return root
        # firstNodeofLevel = root
        # while firstNodeofLevel!= None:
        #     currentNode = firstNodeofLevel
        #     while currentNode != None:
        #         if (currentNode.left != None):
        #             currentNode.left.next = currentNode.right
        #             if (currentNode.next != None):
        #                 currentNode.right.next = currentNode.next.left
        #         currentNode = currentNode.next
        #     firstNodeofLevel = firstNodeofLevel.left
        # return root

        if root is None:
            return root
        self.preorder(root)
        return root

    def preorder(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if(root.left == None) :
            return
        root.left.next = root.right
        if (root.next != None):
            root.right.next = root.next.left
        self.preorder(root.left)
        self.preorder(root.right)


            