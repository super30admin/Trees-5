# Time Complexity:
# O(n)

# Space Complexity:  
# O(h)

# Approach: 
# Inorder traversal, and keep track of which "prev" node is greater than "root" node.
# Use the pointers "first" and "second" to capture the above change.
# Finally, swap the values.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
            self.first = None
            self.second = None
            self.prev = None
            
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        
        self.inorder(root)

        # swap the nodes
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp     

    def inorder(self, root):
        if not root:
            return

        # Recurse left
        self.inorder(root.left)

        # At root, check if "root" node's val is smaller than the "prev" node's val
        if self.prev!=None and self.prev.val > root.val:
            if not self.first:
                self.first = self.prev
            self.second = root
        
        # update the prev node
        self.prev = root

        # Recurse right
        self.inorder(root.right)