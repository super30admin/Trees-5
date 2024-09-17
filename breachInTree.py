# Approach : Inorder traversal iterative
# TC: O(N)
# SC: O(H)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        swap_nodes = []
        
        def inorder(node):
            prev = None
            stack = []
            while node or stack:
                # traverse to left most node
                while node:
                    stack.append(node)
                    node = node.left
                
                # pop the stack
                node = stack.pop()
                # process the node
                # if prev is set then check its value with current
                if prev and prev.val >= node.val:
                    # if len is 0 means we haven't found a breach yet.
                    # so add both nodes to list
                    if len(swap_nodes) == 0:
                        swap_nodes.extend([prev, node])
                    else: # else just update the second item
                        swap_nodes[1] = node
                
                prev = node
                # move to right of the node
                node = node.right
        
        inorder(root)
        swap_nodes[0].val, swap_nodes[1].val = swap_nodes[1].val, swap_nodes[0].val


# Approach: DFS with prev node - same as isValidBST
# TC: O(N)
# SC: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        swap_nodes = []
        prev = [None]
        
        def inorder(node):
            if not node:
                return
            
            inorder(node.left)
            # process the node
            # if prev is set then check its value with current
            if prev[0] and prev[0].val >= node.val:
                # if len is 0 means we haven't found a breach yet.
                # so add both nodes to list
                if len(swap_nodes) == 0:
                    swap_nodes.extend([prev[0], node])
                else: # else just update the second item
                    swap_nodes[1] = node
            prev[0] = node
            inorder(node.right)
            
        
        inorder(root)
        swap_nodes[0].val, swap_nodes[1].val = swap_nodes[1].val, swap_nodes[0].val

