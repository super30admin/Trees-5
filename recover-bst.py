# Time Complexity: O(N)
# Space Complexity: O(N)
# Approach: Traverse the tree inorder. Use two pointers to track the nodes that result in a breach of the BST property. At the end of the traversal, swap the nodes.
class Solution:
    def recoverTree(self, root):
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev = None
        self.first = None
        self.second  = None               
        self.inorder(root)
        
        # Swap
        if(self.first and self.second):
            self.first.val , self.second.val  = self.second.val , self.first.val     


    def inorder(self, node):
        if node is None:
            return

        self.inorder(node.left)

        if(self.prev and node.val < self.prev.val): # Breach
            # If consequetive nodes breach the BST property, set first and second as prev and current node
            if self.first is None:
                self.first = self.prev
                self.second = node
            else: # Set second only if first is not set
                self.second = node

        self.prev = node
        self.inorder(node.right)