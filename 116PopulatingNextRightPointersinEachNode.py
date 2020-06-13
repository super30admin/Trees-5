"""
    // Time Complexity :O(n)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    if node has both left and right child; set node.left.next = node.right
    if node.next it means that node has sibling,so node.right.next = node.next.left
"""
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
    def connect(self, root: 'Node') -> 'Node':
        queue = []
        queue.append(root)
        size = 0
        while queue:

            currentNode = queue.pop()
            if currentNode.left and currentNode.right:
                currentNode.left.next = currentNode.right

                if currentNode.next:
                    currentNode.right.next = currentNode.next.left

            if currentNode.left is not None:
                queue.append(currentNode.left)

            if currentNode.right is not None:
                queue.append(currentNode.right)
        return root
