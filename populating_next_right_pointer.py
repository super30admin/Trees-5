"""
# Definition for a Node.
"""
class Node:
    def __init__(self, val = 0, left = None, right = None, next = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next



# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def connect(self, root):
        #         Base COndition
        if not root:
            return None

        #       we will go till the leftmost node of the tree and we will assign current node
        #       as head of the leftmost element and till that head is not null we will check if left
        #       is present will point its next pointer to current right
        #       Similarly if current next is available and it has right child then we will assign
        #       right next to the current head next left
        #       return root in the end
        head = root
        while head.left:

            curr = head
            while curr:
                if curr.left:
                    curr.left.next = curr.right

                if curr.next and curr.right:
                    curr.right.next = curr.next.left

                curr = curr.next

            head = head.left
        return root



