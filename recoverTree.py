#99. Recover Binary Search Tree
# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
#Iteratively in-order traverse the tree. For a valid BST, the output should be in ascending order. Locate the two nodes where the symmetric order is violated, and swap their values.
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        node, stack = root, []
        prev = lo = hi = None 
        while stack or node:
            if node: 
                stack.append(node)
                node = node.left
                continue
            node = stack.pop()
            if prev and prev.val > node.val: #check symmetric order
                if not lo: lo, hi = prev, node
                else: hi = node 
            prev = node 
            node = node.right 
        lo.val, hi.val = hi.val, lo.val 