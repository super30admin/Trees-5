"""
99. Recover Binary Search Tree
Time Complexity - O(n)
Space Complexity - Length of tree
Here we are using a iterative solution with inorder traversal
So if we traverse a BST in inorder way we will get a array in sorted list hence using this property I have built a solution that will keep pushing root node until left mode node of the tree then we will check if current value is greater than prev value then or if prev is not None(Case for first element) then save top element and prev elements accordingly where there is a chnge in ordering and swap thoe two element value"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        stack = []
        if root == None:
            return
        prev = None
        x = None
        y = None
        while(len(stack) > 0 or root != None):
            while(root != None):
                stack.append(root)
                root = root.left
            top = stack.pop()
            if prev != None and prev.val > top.val:
                y = top 
                if x != None:
                    break
                x = prev
            prev = top
            root = top.right
        temp = x.val
        x.val = y.val
        y.val = temp
        