# Problem 1 : Populating Next Right Pointers in Each Node
# Time Complexity : 
'''
BFS - O(n) where n is the number of nodes in tree
Optimized BFS - O(n) where n is the number of nodes in tree
Recursive DFS - O(n) where n is the number of nodes in the tree
DFS - O(n) where n is the number of nodes in the tree
'''
# Space Complexity : 
'''
BFS - O(n) where n is the numner of nodes
Optimized BFS - O(1)
Recursive DFS - O(h) where h is the height of the tree
DFS - O(h) where h is the height of the tree
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# BFS
from typing import Optional
from collections import deque
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # edge case if the root is None
        if root == None: return root
        # define a deque to store the nodes of tree for doing bfs traversal
        queue = deque()
        # append the root to the queue
        queue.append(root)
        # loop till queue is not empty
        while len(queue) > 0:
            # get the length of the current queue
            length = len(queue)
            # loop from 0 to the current length of the queue ie. loop through a particular level of the tree
            for i in range(length):
                # pop the left element of the queue
                popEle = queue.popleft()
                # check if this element is not the last in the level
                if i != length - 1:
                    # if not then set next pointer to the first element in the queue
                    popEle.next = queue[0]
                # check if the element has left child
                if popEle.left != None:
                    # if it has then append the left and right child to the queue
                    queue.append(popEle.left)
                    queue.append(popEle.right)
        # return the root of the tree
        return root


# Optimized BFS
from typing import Optional
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
        # edge case if the root is None
        if root == None: return root
        # set the level to root
        level = root
        # loop until there is no level left
        while level.left != None:
            # set the current to left most element of the level of the tree
            current = level
            # process the particular level
            while (current != None):
                # set the next pointer of left child of current to right child of the current
                current.left.next = current.right
                # check if the next pointer of the current is not None
                if (current.next != None):
                    # if it is then set the next pointer of right child of the current node to left child of the next node of current
                    current.right.next = current.next.left
                # move the current to next node in the level 
                current = current.next
            # move the level to next level of the tree
            level = level.left
        return root


# Recursive DFS
from typing import Optional
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
        # edge case if the root is None
        if root == None: return

        # dfs function 
        def dfs(left: 'Optional[Node]', right: 'Optional[Node]') -> None:
            # base case
            # check if the left node is None and if it is then return
            if left == None: return
            # set the next pointer of left node to right node
            left.next = right
            # call the dfs function for left and right child of left node 
            dfs(left.left, left.right)
            # call the dfs function for right of left node and left child of right node
            dfs(left.right, right.left)
            # call the dfs function for left and right child of right node 
            dfs(right.left, right.right)

        # calld dfs on left and right child of the root
        dfs(root.left, root.right)
        # return root of the tree
        return root

# DFS
from typing import Optional
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
        # edge case if the root is None
        if root == None: return

        # dfs function
        def dfs(root: 'Optional[Node]') -> None:
            # if the left child of the root is None then return
            if root.left == None: return 
            # set the next pointer of left child of the root to right child of the root node
            root.left.next = root.right
            # check if the next pointer of root is not None
            if (root.next != None):
                # if is not None then set the next pointer of right child of the root to left child of next node of the root
                root.right.next = root.next.left

            # call dfs function for left and right child of root
            dfs(root.left)
            dfs(root.right)

        # call dfs function for root
        dfs(root)
        return root
        
        