# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:


    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Time Complexity: O(N), where N is the number of nodes in the tree.
        Space Complexity: O(h) , where h is the height of the tree.
        """

        if root is None:
            # Base case: If the root is None, there's nothing to recover
            return
        
        # Initialize variables to keep track of the previous node (in in-order traversal),
        # and the first and second nodes that are out of order.
        self.prev = None
        self.first = None
        self.second = None
        
        # Perform an in-order traversal to identify the swapped nodes
        self.dfs(root)
        
        # Swap the values of the two nodes to recover the BST
        self.first.val, self.second.val = self.second.val, self.first.val

    def dfs(self, root):
        if root is None:
            # Base case: If the current node is None, return
            return
        
        # Recur on the left subtree (in-order traversal)
        self.dfs(root.left)
        
        # Check if the previous node's value is greater than the current node's value
        if self.prev is not None and self.prev.val > root.val:
            # If this is the first occurrence of an out-of-order node, record the previous node
            if self.first is None:
                self.first = self.prev
            
            # Record the current node as the second out-of-order node
            self.second = root
        
        # Update the previous node to the current node
        self.prev = root
        
        # Recur on the right subtree (in-order traversal)
        self.dfs(root.right)


########## Iterative Way ############
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Time Complexity: O(N), where N is the number of nodes in the tree.
        Space Complexity: O(h), where h is the height of the tree.
        """
        
        # Initialize pointers for the previous node, the first and second nodes that are out of order
        prev = None
        first = None
        second = None
        stack = []
        
        # Use a stack to perform an iterative in-order traversal
        while stack or root:
            # Traverse to the leftmost node
            while root:
                stack.append(root)
                root = root.left
            
            # Process the node
            root = stack.pop()
            
            # If the previous node's value is greater than the current node's value, we have found an out-of-order pair
            if prev is not None and prev.val > root.val:
                # If this is the first out-of-order pair, record the previous node as 'first'
                if first is None:
                    first = prev
                # Record the current node as 'second'
                second = root
            
            # Update 'prev' to the current node for the next comparison
            prev = root
            
            # Move to the right subtree
            root = root.right
        
