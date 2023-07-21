"""
Time Complexity: 0(n)
Space Complexity: 0(h)
Run on LeetCode: Yes
"""
class Solution:

    def __dfsTraversal(self, leftNode, rightNode):
        # base-case
        if (leftNode == None and rightNode == None):
            return

        # logic-case
        if (leftNode.next != None):
            return
        leftNode.next = rightNode
        self.__dfsTraversal(leftNode.left, leftNode.right)
        self.__dfsTraversal(leftNode.right, rightNode.left)
        self.__dfsTraversal(rightNode.left, rightNode.right)

        return

    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':

        if root!= None and root.left != None and root.right != None:
            self.__dfsTraversal(root.left, root.right)
        return root