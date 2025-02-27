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
    # Tc - O(n)
    #SC - O(n)
    # def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
    #     if not root:
    #         return None
    #     queue = deque()
    #     queue.append(root)
    #     while len(queue)!=0:
    #         size = len(queue)
    #         for i in range(size):
    #             current = queue.popleft()
    #             if i!=size-1:
    #                 current.next = queue[0]
    #             if current.left:
    #                 queue.append(current.left)
    #             if current.right:
    #                 queue.append(current.right)       
    #     return root   

    # TC - O(n)
    # Sc - O(1)
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        left = root
        while left and left.left!=None:
            current = left
            while current!=None:
                current.left.next = current.right
                if current.next!=None:
                    current.right.next = current.next.left
                current = current.next
            left = left.left      
        return root  

        # if root == None:
        #     return 
        # self.dfs(root.left,root.right)
        # return root      

    # TC - O(n)
    # SC - O(H)
    # def dfs(self,left, right):
    #     if left == None:
    #         return
    #     left.next = right
    #     self.dfs(left.left,left.right)   
    #     self.dfs(left.right, right.left)
    #     self.dfs(right.left, right.right)                       
        
