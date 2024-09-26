// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
You have to go to each and every node and connect the left node next to right node and see if the node has a next or not .If yes then we have to connect the children of the cousins.And then agai you the same for right node also.
# # Recursion
# Time complexity --> o(n)
# space complexity --> o(n)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if root==None:
            return 
        node=root
        if node.left==None:
            return node
        node.left.next=node.right
        if node.next!=None:
            node.right.next=node.next.left
        self.connect(node.left)
        self.connect(node.right)
        return root

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
First you need to traverse through all the level first and then store the first index of each node.For every level you have to get the all the nodes.TO connect we first connect the siblings and then connect the cousins.We do this for all the nodes.

# # Iteration
# Time complexity --> o(n)
# space complexity --> o(1)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if root==None:
            return None
        level=root
        while level.left!=None:
            cursor=level
            while cursor!=None:
                cursor.left.next=cursor.right
                if cursor.next!=None:
                    cursor.right.next=cursor.next.left
                cursor=cursor.next
            level=level.left
        return root
        
        
        