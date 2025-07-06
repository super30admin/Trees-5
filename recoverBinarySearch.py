"""
Inorder traversal of a BST yields sorted order
If two nodes are swapped, the sorted order breaks at one or two places
Identify the two wrong nodes and swap their values to recover the tree
"""
"""
Time Complexity - 	O(n) – Inorder traversal
Space Complexity - O(h) – Recursion stack
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class recoverBinarySearch:
    def recoverTree(self, root: 'TreeNode') -> None:
        self.first = self.second = self.prev = None

        def inorder(node):
            if not node:
                return
            inorder(node.left)

            if self.prev and self.prev.val > node.val:
                if not self.first:
                    self.first = self.prev
                self.second = node
            self.prev = node

            inorder(node.right)

        inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val


def inorder_print(root):
    if not root:
        return
    inorder_print(root.left)
    print(root.val, end=' ')
    inorder_print(root.right)

if __name__ == "__main__":
    root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.right.left = TreeNode(2)

    obj = recoverBinarySearch()
    obj.recoverTree(root)

    inorder_print(root)
    print()
