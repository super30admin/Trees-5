"""
//Time Complexity : O(N)
// Space Complexity :O(N) with  queue withourt queue o(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""

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
        
        # T.C = O(n)
        # S.C = O(n)
        from collections import deque
        
        q = deque()
        if root is None:
            return root
        q.append(root)
        while(q):
            size = len(q)
            prev = q.popleft()
            if(prev.left!=None):
                q.append(prev.left)
                q.append(prev.right)
            for i in range(1,size):
                curr = q.popleft()
                if(curr.left!=None):
                    q.append(curr.left)
                    q.append(curr.right)
                prev.next = curr
                prev = curr
        return root
                
                
        