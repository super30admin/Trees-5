# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        nodes = []
        vals = []
        def inorder(node):
            if node:
                inorder(node.left)
                nodes.append(node)
                vals.append(node.val)
                inorder(node.right)
        
        inorder(root)
        n = len(nodes)
        left, right = 0, n-1
        while left < n-1 and nodes[left].val < nodes[left+1].val:
            left += 1
        while right > 0 and nodes[right].val > nodes[right-1].val:
            right -= 1
      
        nodes[left].val, nodes[right].val = nodes[right].val, nodes[left].val
        return root