# Time Complexity : O(n) where n is number of elements in tree
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return

        else:
            temp = root
            # while depth of tree is reached
            while temp is not None:
                node = temp
                # for each node in depth
                while node is not None:
                    # if there is a left child then connect it with right child
                    if node.left:
                        node.left.next = node.right
                        # If there is a next node in current level then join right child of present node with left of next node
                        if node.next:
                            node.right.next = node.next.left
                    node = node.next
                temp = temp.left

            return root