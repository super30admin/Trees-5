## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

# Approach
# Do level order traversal. Use queue and add root to it. For every level, check the size. Traverse queue size times
# pop curr element. If (i != size-1): curr.next = q[0]. if curr.left, append its left and right children to queue
# return root


# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def bfs(self,root):
        q = deque([root])
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if (i != size-1):
                    curr.next = q[0]
                if curr.left:
                    q.append(curr.left)
                    q.append(curr.right)
        
            
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None
        self.bfs(root)
        return root