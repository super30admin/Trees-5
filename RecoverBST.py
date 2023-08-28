"""
Time Complexity: 0(n)
Space Complexity: 0(1)
Run on LeetCode: Yes
"""
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):

        self.first = None
        self.second = None
        self.isBreech = False

        self.previous = None
        self.current = None

    def __dfsTraversal(self, currentNode):
        # base-case
        if currentNode == None:
            return

        # logic-case

        # dfsTraversal on lhs
        self.__dfsTraversal(currentNode.left)

        # back at root
        self.previous = self.current
        self.current = currentNode

        # chk for breech
        if self.previous != None and self.previous.val > self.current.val:
            if self.isBreech == False:
                self.isBreech = True
                self.first = self.current
                self.second = self.previous
            else:
                self.first = self.current

        # dfsTraversal on rhs
        self.__dfsTraversal(currentNode.right)

        return

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.__dfsTraversal(root)
        # swap first and second values
        self.first.val, self.second.val = self.second.val, self.first.val

        
# leetcode submit region end(Prohibit modification and deletion)
