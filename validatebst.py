# // Time Complexity :O(n)
# // Space Complexity :O(logn)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we traverse the tree in its inorder and check if each parent is greate rthan its left and bigger than right. if yes we swap the values.
class Solution(object):
    first=None
    second=None
    prev_element = TreeNode(float('-inf'))
    def traverse(self,root):
        if not root:
            return
        self.traverse(root.left)
        if(self.first is None and self.prev_element.val>root.val):
            self.first=self.prev_element
        if(self.first is not None and self.prev_element.val>root.val):
            self.second=root
        self.prev_element=root
        self.traverse(root.right)
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.traverse(root)
        temp=self.first.val
        self.first.val=self.second.val
        self.second.val=temp
    