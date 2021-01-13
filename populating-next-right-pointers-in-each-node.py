"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
"""
Approach: Level order traversal using BFS (Iterative)

Here we do a level order traversal. During the traversal at each level from left to right we maintain a previous node and current node. We keep updating the next pointer of prev node to current node. 

TC: O(n)
SC: O(2^h)

h = height of the tree
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return root
        
        q = []
        q.append(root)
        
        while len(q) != 0:
            size = len(q)
            prev = None
            
            for i in range(size):
                curr = q.pop(0)
                
                if prev != None:
                    prev.next = curr
                
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                    
                prev = curr
            
        return root


"""
Approach: Level order traversal without using pointer

We will do the same thing as the approach discussed before but we will not use a queue. Instead for every level we will do the following:

curr = level
while curr:
    curr.left.next = curr.right
    if curr.next != None:
        curr.right.next = curr.next.left

    curr = curr.next
    
Then we move on to next level and do the same.

TC: O(n)
SC: O(1)
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return root
        
        level = root
        
        while level.left != None:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                    
                curr = curr.next
                
            level = level.left
            
        return root
            
        
"""
Approach: DFS recursive

Here we will traverse in DFS manner. We will make three following recursive calls and perform only one operation

dfs(left, right):
    left.next = right
    dfs(left.left, left.right) <- To join left and right child of left node
    dfs(right.left, right.right) <- To join left and right child of right node
    dfs(left.right, right.left) <- To join right and left child of left and right node respectively
    
TC: O(n)
SC: O(h)

h = height of the tree
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return root
        
        self.dfs(root.left, root.right)
        return root
    
    def dfs(self, left, right):
        if left == None or right == None:
            return
        
        left.next = right
        
        self.dfs(left.left, left.right)
        self.dfs(right.left, right.right)
        self.dfs(left.right, right.left)
        