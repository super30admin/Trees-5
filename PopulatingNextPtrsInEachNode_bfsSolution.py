"""
Time Complexity: 0(n)
Space Complexity: 0(1)
Run on LeetCode: Yes
"""
class Solution:

    def __init__(self):
        self.currentNode = None
        self.lvl = 0

    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        start = root
        self.currentNode = root

        while (root!= None and self.currentNode != None):

            # base-case
            if root.left == None and root.right == None:
                break

            # logic-case
            self.currentNode.left.next = self.currentNode.right
            if self.currentNode.next != None:
                self.currentNode.right.next = self.currentNode.next.left
                self.currentNode = self.currentNode.next
                continue

            else:
                self.lvl += 1
                root = root.left
                self.currentNode = root
        '''end of while loop'''

        root = start
        start = None
        self.currentNode = None

        return root