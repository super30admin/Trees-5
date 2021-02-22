# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Description: fix BST with one breach of rule (swap back to original values)
    
    Time Complexity: O(n), n -> number of items in the tree
    Space Complexity: O(h), h -> height of the tree (recursive stack)
    
    Approach: Use inOrder traversal
    - to avoid using extra space, assign 2 nodes first and last 
    - record previous and current node for inorder traversal, flag if rule is broken first time
    - when rule is broken again, update the last node by current node
    - prevent going through all the nodes by turning flag back to False when second breach is found
    """
    
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if root == None: return
        
        self.first = None; self.last = None
        self.prev = None
        
        self.flag = False

        self.inOrder(root)
        self.first.val, self.last.val = self.last.val, self.first.val
 
        
    def inOrder(self, root):
        
        # base
        if root == None: return
        
        # logic
        self.inOrder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if not self.flag: # first breach
                self.first, self.last = self.prev, root
                self.flag = True
            else: # second breach
                self.last = root
                self.flag = False

        self.prev = root
        if self.first and self.last and self.flag == False:
            pass
        else:
            self.inOrder(root.right)
