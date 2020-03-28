'''
Title Populating Next Right Pointers in Each
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: iterate through the tree level by level by starting at the leftmost node.
we set cursor.left.next = cursor.right and  if cursor.next != None set cursor.right.next = cursor.next.left
'''


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return root

        if root.left != None:
            root.left.next = root.right

            if root.next != None:
                root.right.next = root.next.left

        self.connect(root.left)
        self.connect(root.right)

        return root

    def connectIter(self, root: 'Node') -> 'Node':
        if root == None:
            return root

        level = 0
        firstNodeLevel = root

        while firstNodeLevel.left != None:
            cursor = firstNodeLevel

            while cursor != None:
                cursor.left.next = cursor.right

                if cursor.next != None:
                    cursor.right.next = cursor.next.left

                cursor = cursor.next

            firstNodeLevel = firstNodeLevel.left

        return root