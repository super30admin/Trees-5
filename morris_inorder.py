# Morris inorder traversal
# Time complexity - )(n)
# Space complexity - O(1)
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result  = []
        curr = root
        while curr:
            # add the val to the result when we hit left leaf node
            if not curr.left:
                result.append(curr.val)
                curr = curr.right
            else:
                # make left node the predecessor
                pre = curr.left
                # move to the right most node and create a link to the parent
                while pre.right and pre.right != curr:
                    pre = pre.right
                # create link when going downward
                if not pre.right:
                    pre.right = curr
                    curr = curr.left
                else:
                # remove link when going upwards and print when rightmost node is empty
                    pre.right = None
                    result.append(curr.val)
                    curr = curr.right
        return result







