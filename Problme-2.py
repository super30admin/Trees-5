
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
	    def inorder(root):
            if not root: return []
            return inorder(root.left)+[root]+inorder(root.right)

        v=inorder(root)
        vals = sorted(x.val for x in v)

        for i in range(len(v)):
            v[i].val = vals[i]
