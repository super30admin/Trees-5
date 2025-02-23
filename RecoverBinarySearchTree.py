#Time Complexity: O(n), where n is the number of nodes in the tree, as each node is visited once during the in-order traversal.
#Space Complexity: O(h), where h is the height of the tree, due to the recursive call stack. In the worst case, this is O(n) for a skewed tree, and O(log n) for a balanced tree.
class Solution:
    prev = None
    first = None
    second = None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.helper(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
    def helper(self, root):
        if(root==None):
            return 
        self.helper(root.left)
        if(self.prev != None and self.prev.val >= root.val):
            if(self.first == None):
                self.first = self.prev  
                self.second = root 
            else:
                self.second=root
        self.prev = root
        self.helper(root.right)