# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global idx
    idx = 0

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        global idx
        """
        Do not return anything, modify root in-place instead.
        """
        # Approach 1
        # Perform inorder traversal and create a list of the traversal
        # Time : O(n)
        # Space Complexity: O(n)
        in_list = []

        def inorder_fill(root):
            global idx
            if not root: return
            inorder_fill(root.left)
            # print(idx)
            root.val = in_list.pop()
            idx += 1
            inorder_fill(root.right)

        def inorder(root, in_list):
            if not root: return
            inorder(root.left, in_list)
            in_list.append(root.val)
            inorder(root.right, in_list)

        inorder(root, in_list)

        in_list.sort(reverse=True)

        inorder_fill(root)

    # Approach 2 Perform inorder traversal with two pointers
    # Time : O(n)
    # Space : O(1)
    global prev, first, second

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        global prev, first, second
        first = None
        second = None
        prev = None
        """
        Do not return anything, modify root in-place instead.
        """

        def inorder(root):
            global prev, first, second
            if not root: return

            inorder(root.left)
            if prev and prev.val >= root.val:
                if not first:
                    # print("First")
                    first = prev
                    second = root
                else:
                    # print("Second")
                    second = root
                # print(first.val, second.val)
            prev = root
            inorder(root.right)

        inorder(root)
        # print(first.val, second.val)
        # temp = first.val
        # first.val = second.val
        # second.val = temp
        first.val, second.val = second.val, first.val
