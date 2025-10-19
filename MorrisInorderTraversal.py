# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n)
    # sc : O(1)
    # ran successfully on leetcode
    def inorderTraversal(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        # inorder -> left root right
        # we keep gng to the left and if there is no left we jst move from root to right and store values
        # but if we do we shoudl first take left and then we have to move to the root ( for that we can create a link connection between the left most to the curr root )
        # so that after left we go to the root and rigth and so on.. this way we don't need the recrussive stack and not take any extra complexity

        res = []
        curr = root
        while curr is not None:
            if curr.left is None : # no left tree just collect this root and move to the right
                res.append(curr.val)
                curr = curr.right
            else : # lets go to the left most child
               pre = curr.left
               while pre.right is not None and pre.right != curr: # as we connect our right to root, we have to check the condition 
                   pre = pre.right

               if pre.right is None:
                    # reached to the rigth most where its none so lets establish the link to this child to the curr 
                    pre.right = curr 
                    curr = curr.left # we are at node where its rght connection pointed to the curr, and then we move ot the left we get that and then we get the root
                    # this is how after left we move to the root and then right and so on...
               else :
                # already has the right lets add that and keep movin g to the end right
                pre.right = None
                res.append(curr.val)
                curr = curr.right

        return res

            
        