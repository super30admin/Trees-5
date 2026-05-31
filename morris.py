class Solution:
    def morrisInorderTraversal(self, root):
        curr = root
        while curr is not None:
            if curr.left is None:
                print(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right is not None and pre.right != curr:
                    pre = pre.right

                if pre.right is None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    print(curr.val)
                    curr = curr.right

# Time: O(n)
# Space: O(1)