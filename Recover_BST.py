"""
Approach:
- In a correct BST, inorder traversal gives nodes in strictly increasing order.
- If two nodes are swapped, this order breaks.
- Traverse the tree inorder and find two nodes `first` and `second`:
    - First violation: previous node > current → mark `first = prev`, `second = current`
    - Second violation: update `second = current` again
- Swap their values to fix the tree.

Time Complexity: O(n) — full inorder traversal
Space Complexity: O(h) — recursive stack height (h = height of tree)
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
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

def print_inorder(root):
    if not root:
        return []
    return print_inorder(root.left) + [root.val] + print_inorder(root.right)


def build_swapped_tree():
    root = TreeNode(2)
    root.left = TreeNode(3)
    root.right = TreeNode(1)
    return root


def main():
    root = build_swapped_tree()
    print("Before recovery:", print_inorder(root))
    Solution().recoverTree(root)
    print("After recovery:", print_inorder(root))


if __name__ == "__main__":
    main()