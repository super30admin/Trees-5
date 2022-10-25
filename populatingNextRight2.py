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
        if root is None:
            return root
        
        self.dfs(root, 0, result)
        
        for level in result:
            for i in range(len(level)):
                if i == len(level) - 1:
                    level[i].next = None
                else:
                    level[i].next = level[i+1]
        
        return root

    
    def dfs(self, curr, depth, result):
        if curr is None:
            return
        
        if depth == len(result):
            temp = []
            result.append(temp)
        
        result[depth].append(curr)
        
        self.dfs(curr.left, depth + 1, result)
        self.dfs(curr.right, depth + 1, result)
                    
                
        