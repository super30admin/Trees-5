"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
 
class Solution:
    # time complexity: O(n)
    # space complexity: O(n)
    # we do level order traversal
    # add root to queue and loop while queue is not. empty
    # loop on size of queue
    # pop from left side and store in temp then  add left and right of the temp  to queue
    # when at last element of level temp.next == None
    # else temp.next ==  first element of queue
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return
        
        Q = deque()
        Q.append(root)

        while(len(Q)>0):
            qsize = len(Q)
            for i in range(qsize):
                temp = Q.popleft()
                # append left and right of root
                if temp.left:
                    Q.append(temp.left)
                if temp.right:
                    Q.append(temp.right)
                # it's the last element
                if i == qsize-1:
                    temp.next = None
                else:
                    # this is level order traversal so elements will be pushed in order
                    temp.next = Q[0]
        return root



       