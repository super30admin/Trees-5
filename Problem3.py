'''
1. Morris traversal is based on keeping track of a predecessor node - rightmost node of left subtree for a current node
2. If a node doesnt have a left subtree print it, move to the right.
3. If a node has a left child, link the predecessor node to the current node and then move further left.
4. If the current node was encountered while finding predecessor, that means left subtree has been completely traversed, print
   the curr node(root) and move to the right.

TC: O(n)
SC: O(1) -> No stack used. Only right pointers of left subtrees are modified to root nodes.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        curr = root
        res = []
        while curr:
            if curr.left == None:
                res.append(curr.val)
                curr = curr.right
            else:
                predecessor = curr.left
                while predecessor.right and predecessor.right != curr:
                    predecessor = predecessor.right

                if predecessor.right is None:
                    predecessor.right = curr
                    curr = curr.left
                
                else:
                    predecessor.right = None
                    res.append(curr.val)
                    curr = curr.right
                
        return res
