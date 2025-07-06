# TC: O(n)
# SC: O(h)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        def helper(left,right):
            #base
            if not left:
                return
            #logic
            left.next=right
            helper(left.left, left.right)
            helper(left.right, right.left)
            helper(right.left,right.right)
        
        if root:
            helper(root.left,root.right)
        
        return root
