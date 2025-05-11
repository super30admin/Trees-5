# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree
# Approach : DFS
# 1. We will use a DFS approach to find the two nodes that are swapped.
# 2. We will use a prev pointer to keep track of the previous node.
# 3. We will use a first and second pointer to keep track of the two nodes that are swapped.
# 4. We will traverse the tree in an inorder fashion and check if the previous node is greater than the current node.
# 5. If it is, we store the previous node in the first pointer and the current node in the second pointer.
# 6. If we find the second node with a value greater than its previous node, we store it in the second pointer.
# 7. Finally, we swap the values of the first and second pointers.
class Solution:
    def recoverTree(self, root) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev = None
        self.first = None
        self.second = None
        def dfs(root):
            if not root:
                return

            dfs(root.left)
            if self.prev and self.prev.val > root.val:
                if self.first != None:
                    self.second = root
                else:
                    self.first = self.prev
                    self.second = root
            self.prev = root
            dfs(root.right)

        dfs(root)
        self.first.val, self.second.val = self.second.val, self.first.val