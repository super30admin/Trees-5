"""
For each node, find its inorder predecessor (rightmost node in left subtree)
If the predecessor’s .right is null, make it point to the current node and move left
If it already points to current, revert it, visit the current node, and move right
"""
"""
Time Complexity - O(n) - Traverse through all nodes
Space Complexity - O(1) (no recursion/stack)
"""
    
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class binaryTreeInorder:
    def inorderTraversal(self, root: 'TreeNode') -> list[int]:
        res = []
        curr = root
        while curr:
            if not curr.left:
                res.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right and pre.right != curr:
                    pre = pre.right

                if not pre.right:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    res.append(curr.val)
                    curr = curr.right
        return res

if __name__ == "__main__":
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)

    obj = binaryTreeInorder()
    print(obj.inorderTraversal(root))
