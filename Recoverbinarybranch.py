# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n) 
    # sc : O(h) recrussive stack space 
    # ran successfully on leetcode
    def recoverTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """
        # lets do inorder travsersal and as its a binary search tree the inorder traversal the value should be in a sorted order
        # in recovering the tree we shouod identify the two nodes which need to be swapped , the nodes can be adjancet or non adjancet so we will have to store the nodes in first, second 
        # first violation is when we are dng the inorder the prev valu is greater then the curr valu that means we gota higher value too early and it need to be swapped with a smaller one, we stoe this self.prev whihc is higher val as our firt node
        # second violation when the root val is less than the prve, the value shoudo not be this less so the second violation we will save this root value in our second violation and in the end we will swap them up

        self.prev = self.first = self.second = None

        self.helper(root)

        if self.first and self.second:
            self.first.val, self.second.val = self.second.val, self.first.val

        return root

    def helper(self,root):
        if root is None :
            return None
        
        self.helper(root.left) 

        if self.prev is not None and self.prev.val > root.val:
            if self.first is None:
                self.first = self.prev # the prev node is higher so we need to save this to place it correctly
                self.second = root # setting the temporarly the value
            else :
                self.second = root # find the second violation node and assign it 
            
        self.prev = root

        self.helper(root.right)





        
