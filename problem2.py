#Time Complexity O(N)
#Space Complexity O(N)

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        
        def inorder(root):
            nonlocal first, second, prev 
            if not root:
                return 
            inorder(root.left)
            if prev and root.val < prev.val:
                second = root
                if first is None:
                    first = prev
            prev = root
            inorder(root.right)

        first = second = prev = None 
        inorder(root)
        first.val , second.val = second.val , first.val
