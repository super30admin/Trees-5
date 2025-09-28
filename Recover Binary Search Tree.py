#  Time Complexity : O(N) 
#  Space Complexity : O(N) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code fixes a binary search tree (BST) where two nodes have been swapped by mistake. It performs an inorder traversal (which should yield a sorted sequence for a valid BST) and stores all nodes in a list, then scans the list to detect two nodes that are out of order. Finally, it swaps the values of those two nodes to restore the BST property.


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
        # TC: O(N)  SC: O(N)
        self.inorderNodes = []
        self.inorder(root)

        first = None
        second = None

        for i in range(len(self.inorderNodes) - 1):
            currVal = self.inorderNodes[i].val
            nextVal = self.inorderNodes[i+1].val

            if currVal > nextVal:
                if first is None:
                    first = self.inorderNodes[i]
                    second = self.inorderNodes[i+1]
                else:
                    second = self.inorderNodes[i+1]
                    break
        
        if first is not None and second is not None:
            temp = first.val
            first.val = second.val
            second.val = temp

    
    def inorder(self, root):
        if root is None:
            return
        self.inorder(root.left)
        self.inorderNodes.append(root)
        self.inorder(root.right)