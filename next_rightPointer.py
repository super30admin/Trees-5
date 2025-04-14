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
    def connect(self, root: 'Node') -> 'Node':

        """
        BFS
        TC:O(n)
        
        """
        level=root
        while level:
            cur=level
            while cur:
                if cur.left:
                    cur.left.next=cur.right
                    if cur.next:
                        cur.right.next=cur.next.left
                cur=cur.next 
            level=level.left
        return root

            
    
    
#     """
#     keyIdea: connect every left child to right child in left and right most child of left tree to left node of right tree
#     """
# #     def connect(self, root: 'Node') -> 'Node':
# #         leftmostnode=root
    
# #         while(leftmostnode.left):
# #             cur=leftmostnode
# #             while cur:
# #                 # connect left to right child
# #                 cur.left.next=cur.right
                
# #                 # current right to next left
# #                 if cur.next:
# #                     cur.right.next=cur.next.left
# #                 # move cur pointer
# #                 cur=cur.next
                
# #             leftmostnode=leftmostnode.left
# #         return root
                

        
        