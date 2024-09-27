"""
Runtime Complexity:
O(n)-  where 'n' is the number of nodes. We traverse all the nodes to set the pointers.
Space Complexity:
O(1) - No extra space was used to compute the solution because we used pointers.
Yes, the code worked on leetcode.
Issues while coding - No
"""
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None
        lvl = root
        curr = None
        
        while (lvl.left!=None):
            curr  = lvl
            while curr!=None:
                curr.left.next = curr.right
                if curr.next!=None:
                    curr.right.next = curr.next.left
                curr = curr.next
            lvl = lvl.left
        return root
        