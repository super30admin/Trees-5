"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

#All TC on leetocde passed


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':

        #Here DFS can also be done, refer notes

        #Here we use level pointer to traverse level nodes and simultaneously connect the level's children nodes.
        #Time complexity - O(n) - traverse all nodes
        #Space complexity - O(1)
        level = root
        while level:

            cur = level
            while cur and cur.left:
                cur.left.next = cur.right
                if cur.next:
                    cur.right.next = cur.next.left
                cur = cur.next
            
            level = level.left
        
        return root


#-------------------------------------------OR---------------------------------------------
        
        #Here we use queue to hold all nodes of a level and then connect them
        #Time complexity - O(n) - traverse all nodes
        #Space complexity - O(n) - queue size max holds all leaf node n/2
        q = collections.deque()
        q.append(root)

        while q:
            prev = None
            for i in range(len(q)):
                cur = q.popleft()
                if prev:
                    prev.next = cur

                if cur and cur.left:
                    q.append(cur.left)
                    q.append(cur.right)
                prev = cur

        return root
            



        