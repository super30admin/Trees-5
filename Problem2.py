#I used an in-order traversal approach. By traversing the tree in in-order sequence, which should naturally produce a sorted list of values in a BST, I detected the two nodes that are out of order. The prev pointer helps identify the first and last nodes involved in the swap. Once these nodes are identified, I swapped their values to restore the BST property. This method ensures the tree is corrected in-place, efficiently handling the problem with a time complexity of O(n) and a space complexity of O(h) due to the recursive traversal.

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
        self.temp =[]
        prev=start=last=None
        def in_order_traversal(node):
            nonlocal start,prev,last
            if not node:return
            in_order_traversal(node.left)

            if prev and prev.val>node.val:
                if not start:
                    start = prev
                last = node
            
            prev=node

            in_order_traversal(node.right)
            
        in_order_traversal(root)

        #swap
        if start and last:
            start.val,last.val = last.val,start.val