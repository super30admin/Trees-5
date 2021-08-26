#Time Complexity: O(N)

#Space Complexity: O(N) 
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        
        queue = deque()
        queue.append(root)
        prev = root
        while(queue):
            que_len = len(queue)
            prev = queue.popleft()
            if prev.left :
                queue.append(prev.left)
            if prev.right:
                queue.append(prev.right)
            for i in range(1,que_len):
                cur = queue.popleft()
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                prev.next = cur
                prev = cur
            prev.next = None
        return root