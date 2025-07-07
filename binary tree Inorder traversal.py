#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution(object):

    #Iterative approach

    def inorderTraversal(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        res = []
        stack = []
        curr = root
        
        while curr or stack:

            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            res.append(curr.val)
            curr = curr.right

        return res
        