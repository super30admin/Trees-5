# Time Complexity : O(n), Where n is number of elements in the perfect binary tree
# Space Complexity : O(n), Where n is number of elements in the perfect binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

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
        if(root==None):
            return root
        
        queue=deque()
        queue.append(root)
        while(len(queue)!=0):
            size=len(queue)
            for i in range(size):
                top=queue[0]
                if(top.left!=None):
                    queue.append(top.left)
                if(top.right!=None):
                    queue.append(top.right)
                queue.popleft()
                if(i!=size-1):
                    top.next=queue[0]
        
        return root
                
        