#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        q = deque()
        q.append(root)
        
        if root is None:
            return root
        
        while q:
            size = len(q)
            for i in range(size):
                el = q.popleft()
                if i < size-1:
                    el.next = q[0]
                    
                if el.left:
                    q.append(el.left)
                    
                if el.right:
                    q.append(el.right)
                    
        return root
                
                