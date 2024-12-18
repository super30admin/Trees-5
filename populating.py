# The connect method populates each node's `next` pointer to point to its next right node in a perfect binary tree.

# Base Case:
# - If the tree is empty, return None.

# Recursive DFS:
# - Set the left child's `next` pointer to the right child.
# - If the current node has a `next` pointer, link the right child to the left child of the next node.
# - Recursively process the left and right subtrees.

# Return the root after populating all `next` pointers.

# TC: O(n) - Each node is visited once.
# SC: O(h) - Space for the recursion stack, where h is the tree height.


from typing import Optional
from xml.dom import Node


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if( root == None ):
            return
        root.next = None
        def dfs(node):
            if( node == None or node.left == None ):
                return
            node.left.next = node.right
            if(node.next):
                node.right.next =node.next.left
            dfs(node.left)
            dfs(node.right);    

        dfs(root)
        return root