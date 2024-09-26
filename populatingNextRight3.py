#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

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
        result = []
        queue = []
        if root is None:
            return root
        queue.append(root)
        
        while queue:
            size = len(queue)
            temp = []
            for i in range(size):
                curr = queue.pop(0)
                temp.append(curr)
                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
            result.append(temp)
        
        for level in result:
            for i in range(len(level)):
                if i == len(level) - 1:
                    level[i].next = None
                else:
                    level[i].next = level[i+1]
        
        return root
                    
                
        