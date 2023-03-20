// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution:

    # def __init__(self):
    #     self.first = TreeNode(0)
    #     self.second = TreeNode(0)
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return None

        first = second = prev = None

        def inorder(root: Optional[TreeNode]):
            nonlocal first, second, prev

            st = []
            while root!= None or len(st)!= 0:
                while root:
                    st.append(root)
                    root = root.left
                root = st.pop()
                if prev is not None and prev.val>=root.val:
                    if first is None:
                        first = prev
                        second = root
                        # print(first.val, second.val)
                    else:
                        second = root
                prev = root
                root = root.right
                # print(first, second)

        # print(first)
        inorder(root)
        # print(root, first.val, second.val)
        temp = first.val
        first.val = second.val
        second.val = temp
