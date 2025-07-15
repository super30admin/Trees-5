# Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        while root:
            if not root.left:
                result.append(root.val)
                root = root.right
            else:
                predecessor = root.left
                while predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right
                
                if not predecessor.right:
                    predecessor.right = root
                    root = root.left
                else:
                    predecessor.right = None
                    result.append(root.val)
                    root = root.right
        return result
