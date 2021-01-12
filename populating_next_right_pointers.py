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
        
        #travel levelwise
        
        #using dfs
        #O(n)
        #O(h)
#         if not root:
#             return
#         #start with child nodes
#         self.dfs(root.left,root.right)
#         return root
#     def dfs(self,left,right):
#         #its perfect balanced tree if left doesnot exist that means nothing exists after that as well
#         if not left:
#             return
#         #make next pointer 
#         #(2>3)
#         left.next=right
#         #(4>5)
#         self.dfs(left.left,left.right)
#         #(5>6)
#         self.dfs(left.right,right.left)
#         #(6>7)
#         self.dfs(right.left,right.right)
        
        
        #using bfs
        #O(n)
        #O(n)
        # if not root:
        #     return
        # q=deque()
        # q.append(root)
        # while q:
        #     qsize=len(q)
        #     for i in range(qsize):
        #         cur=q.popleft()
        #         #if this is not the last element in queue
        #         #populate its next pointer to top element in queue
        #         if i!=qsize-1:
        #             cur.next=q[0]
        #         if cur.left:
        #             q.append(cur.left)
        #         if cur.right:
        #             q.append(cur.right)
        # return root
        
        #using bfs
        #O(n)
        #O(1)
        #dummy level pointer for root
        if not root:
            return 
        level=root
        #just one condition for perfect binary tree
        while level.left:
            #current node from level
            cur=level
            while cur:
                #update pointers
                cur.left.next=cur.right
                if cur.next:
                    cur.right.next=cur.next.left
                #move forward to next element in same level
                cur=cur.next
            #move forward to next level
            level=level.left
        return root
        
                    
            
        
        
        
        