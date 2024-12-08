# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        #TC: O(nxh) - in worst case, but averagely O(n) as left nodes and above that inner loop will run        only once
        #SC: O(1)
        #maintain two pointers curr and prev
        #let the prev pointer point to the predecessor for that node, in this case it will be
        #the rightmost node of it's left child
        #when we are traversing downwards we make the connection, 
        #so will make the right pointer of pre ->curr
        #when we move up we print the element and break the connection for right pointer again, 
        #so the struc reamins the same

        curr = root
        out = []
        pre = root
        while curr: #n
            if curr.left is None:
                out.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right and pre.right != curr: #h
                    pre = pre.right
                if pre.right is None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    out.append(curr.val)
                    curr = curr.right
        return out

        