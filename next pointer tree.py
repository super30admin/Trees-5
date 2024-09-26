# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Go to each level with pointer level
# from their use current pointer to move right
# at each level edit next pointer of its chilldren


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None: return None
        
        def helper(left, right):
            #base
            if not left: return
            #logic
            left.next = right
            helper(left.left, left.right)
            helper(left.right, right.left)
            helper(right.left, right.right)
        helper(root.left, root.right)
            
            
            
        
        
        # Best Solution with DFS 
        level = root
        while level.left:
            cur = level
            while cur:
                cur.left.next = cur.right
                if cur.next:
                    cur.right.next = cur.next.left
                cur = cur.next
            level = level.left
        return root
        
        
        
        
        
        # BFS
        # q = deque()
        # q.append(root)
        # # prev = Node(-1)
        # while q:
        #     size = len(q)
        #     for i in range(size):
        #         curr = q.popleft()
        #         if i != size-1:
        #             curr.next = q[0]
        #         if curr.left: 
        #             q.append(curr.left)
        #             q.append(curr.right)
        #         # prev = curr
        #     # prev = Node(-1)
        # return root
            
        