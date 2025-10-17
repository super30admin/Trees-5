# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Solution : Inorder DFS + check for breach
    - InOrder will give ascending order. Check for breach
    - 2 types of breach:
        - Adjacent nodes breach  # eg1 [1,3,null,null,2]  -> 1&3 breach
        - Distant nodes breach  # eg2 [3,1,4,null,null,2] -> 3&2 breach
    - Maintain first and last breach nodes to store the breach
    - When first breach happens,
        - populate first breach with previous node in the InOrder
        - populate last breach node with current node in the InOrder
    - When second breach happens,
        - update last breach node with current node in the InOrder
    - Once traversal is complete, swap the values of first breach and last breach nodes
Time Complexity: O(N)
Space Complexity: O(h), h = height of tree
'''
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first_breach = None
        self.last_breach = None
        self.prev = None
        
        self.helper(root)
        
        temp  = self.first_breach.val
        self.first_breach.val = self.last_breach.val
        self.last_breach.val = temp
 
    def helper(self,node):
        # base
        if node == None:
            return

        # logic
        self.helper(node.left) # left
        
        if self.prev!=None and node.val<self.prev.val: # process node, check for breach
            if self.first_breach is None: # first breach
                self.first_breach = self.prev 
                self.last_breach = node
            else: # second breach
                self.last_breach = node
        self.prev = node
        self.helper(node.right) # right

        