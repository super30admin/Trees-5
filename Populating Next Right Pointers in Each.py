
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # optimized with space O(1)

        if root is None:
            return None

        level = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left

        return root
