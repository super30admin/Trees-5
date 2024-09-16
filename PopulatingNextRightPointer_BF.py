# TC: O(N) since we are traversing all the nodes. 
# SC: O(N) since we use a queue, to perform the BFS. 

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: 
            return
        queue = collections.deque()
        queue.append(root)
        while queue: 
            size = len(queue)
            prev = queue.popleft()
            if prev.left: 
                queue.append(prev.left)
                queue.append(prev.right)        
            for i in range(1, size): 
                curr = queue.popleft()
                prev.next = curr
                if curr.left: 
                    queue.append(curr.left)
                    queue.append(curr.right)
                prev = curr
        return root
