#TC - O(N)
#SC - O(1)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        def dfs(root):
            if root is None:
                return
            if root.left and root.right:
                root.left.next = root.right
            if root.next and root.next.left:
                root.right.next = root.next.left
            dfs(root.left)
            dfs(root.right)
           
            return root
        return dfs(root)