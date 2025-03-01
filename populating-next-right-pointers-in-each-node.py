# tc O(n), sc O(breadth = n).
if not root:
    return None
from collections import deque
queue = deque([root])

while queue:
    prev = None
    for _ in range(len(queue)):
        node = queue.popleft()
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
        if prev:
            prev.next = node
        prev = node

return root