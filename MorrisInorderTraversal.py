# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # time complexity: Amortized O(n)
    #  space complexity: O(1)

    # this is morris inorder traveral
    # traverse to root.left and then traverse to it's right till None to get it's predesecer
    # set pre then then travers to right till pre.right == None or curr
    # if None then set right as curr else add curr to result and repeat
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:

        result = []
        curr = root
        
        while curr != None:
            if curr.left == None:
                result.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right!= None and pre.right!= curr:
                    pre = pre.right
                if pre.right == None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    result.append(curr.val)
                    curr = curr.right
        return result


        