#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return
        left = root
        curr = root
        while left.left:
            curr = left
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            left = left.left
        return root
        