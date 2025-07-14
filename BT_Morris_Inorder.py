"""
Approach:
- This is Morris Inorder Traversal.
- We traverse the binary tree in inorder (left, root, right) without using recursion or a stack.
- For each node:
    - If left is None → visit it and go right.
    - Else → find its inorder predecessor:
        - If predecessor's right is None, set it to current (thread) and move left.
        - If predecessor's right is current, remove the thread, visit node, and move right.
- This creates temporary links (threads) and reverts them, ensuring no extra space is used.

Time Complexity: O(n), where n is the number of nodes.
Space Complexity: O(1), no recursion/stack used.
"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def inorder(self, root):
        result = []
        curr = root

        while curr:
            if not curr.left:
                result.append(curr.val)
                curr = curr.right
            else:
                prev = curr.left
                while prev.right and prev.right != curr:
                    prev = prev.right

                if not prev.right:
                    prev.right = curr
                    curr = curr.left
                else:
                    prev.right = None
                    result.append(curr.val)
                    curr = curr.right
        return result

def build_example_tree():
    root = TreeNode(4)
    root.left = TreeNode(2, TreeNode(1), TreeNode(3))
    root.right = TreeNode(5)
    return root


def main():
    sol = Solution()
    root = build_example_tree()
    result = sol.inorder(root)
    print(f"Inorder traversal: {result}")  # Expected: [1, 2, 3, 4, 5]


if __name__ == "__main__":
    main()