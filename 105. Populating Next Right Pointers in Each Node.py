# Time Complexity: O(n)
# Space Complexity: O(n)

# ------------------------Iterative Approach-----------------------
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None: return None
        queue = []
        queue.append(root)
        
        while queue:
            size = len(queue)
            prev = None
            for i in range(size):
                curr = queue.pop(0)
                if i != 0:
                    prev.next = curr
                if curr.left != None:
                    queue.append(curr.left)
                    queue.append(curr.right)
                prev =curr    
        return root

# ------------------------Another Approach------------------------
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None: return None
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

# ----------------Recursive (Symmtric Tree) Approach--------------
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None: return None
        if root.left:
            self.helper(root.left, root.right)
        return root
    
    def helper(self, left, right):
        if left == None: return
        
        left.next = right
        self.helper(left.left, left.right)
        self.helper(left.right, right.left)
        self.helper(right.left, right.right)