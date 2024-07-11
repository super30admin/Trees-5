# Time Complexity : O(n)
# Space Complexity : O(1)
from typing import Optional, TreeNode, Node
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None
        
        node = root
        while node.left:
            head = node
            while head:
                head.left.next = head.right
                if head.next:
                    head.right.next = head.next.left
                head = head.next
            node = node.left
        return root