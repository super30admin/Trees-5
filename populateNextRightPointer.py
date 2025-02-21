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
    # BFS approach
    # TC : O(n)
    # SC : O(n)
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        def levelordertraversal(root):
            res = []
            if root is None:
                return res
            q = collections.deque()
            q.append(root)
           
            while q:
                cursize = len(q)
                curlist = []
                while cursize>0:
                    curnode = q.popleft()
                    cursize -= 1
                    curlist.append(curnode)
                    if curnode.left:
                        q.append(curnode.left)
                    if curnode.right:
                        q.append(curnode.right)
                res.append(curlist)
            print(res)
            return res
        levelarr = []
        levelarr = levelordertraversal(root)
        for i in range(len(levelarr)):
            l = len(levelarr[i])
            if i == 0:
                node = levelarr[i][0]
                node.next = None
            else:
                for j in range(l-1):
                    node = levelarr[i][j]
                    node.next = levelarr[i][j+1]
                node = levelarr[i][l-1]
                node.next = None
        return root