'''
Accepted on leetcode(99)
Time - O(N), Space - O(N)
Method:
1. InOrder Traversal
2. Validate BST using inorder
3. Implement the problem and swap the node values where they are misplaced.
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # Initialize variables
        stack = []
        x = None
        y = None
        prev = None

        # Iterate the stack is not empty and whole tree is processed.
        while stack or root != None:
            # Traverse till left leaf node, for inorder
            while root != None:
                stack.append(root)
                root = root.left

            top = stack.pop()

            # check for swapped values.
            if prev != None and prev.val > top.val:
                x = top
                print(x.val)
                if y is None:
                    y = prev

            # root and right part in BST
            prev = top
            root = top.right

        # If the both the elements found then swap them.
        self.swap(x, y)

    def swap(self, x, y):
        temp = x.val
        x.val = y.val
        y.val = temp