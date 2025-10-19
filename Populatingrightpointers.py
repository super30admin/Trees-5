"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution(object):
    # tc : O(n)
    # sc : O(1)
    # ran successfully on leetcode
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        # maintain a level and we will use this as a placeholder and other vairable curr to move across that level
        # and basically the curr.left.next should be connected to curr.right and so on so the toort childs root.left.next should be connected to the root.right 
        # once we reach the end of this i.e curr is noen then we will update our level and keep populating the next right pointers

        if root is None:
            return None
        
        level = root

        while level.left :
            curr = level 

            while curr :
                curr.left.next = curr.right

                if curr.next is not None: 
                    curr.right.next = curr.next.left

                curr = curr.next
            
            level = level.left # finsihed the level lets move to the next level by moving to its child

        
        return root # all the next pointers pointed to the right

