"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
#Time Complexity: O(n)
#Space Complexity: O(n)
'''
BFS solution, do a order level traversal and point prev to curr.To 
take care of the first element, we create a dummy node and detach it after the 
level.

'''

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: return root
        q=collections.deque()
        q.append(root)
        
        while q:
            size,n,dummy=len(q),0,Node(0)
            prev=dummy
            while n<size:
                n+=1
                node=q.popleft()
                prev.next=node
                prev=node
                if node.left or node.right:
                    q.append(node.left)
                    q.append(node.right)
            dummy.next=None
        return root
        
        
        
#WITHOUT EXTRA SPACE!
#Time Complexity: O(n)
#Space Complexity: O(1)
'''
We see that from a parent, we can directly connect the children, furthermore once 
one layer is connected ,we can connect all the children of that generation by using
the previous next pointers created (bridge). We make sure curr.left exists (we
stop before reaching the last layer, since we proccess the children at every
layers).
'''

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: return root
        q=collections.deque()
        q.append(root)
        curr,temp=root,root
        while curr.left:
            temp=curr.left
            while curr:
                curr.left.next=curr.right
                if curr.next:
                    curr.right.next=curr.next.left
                curr=curr.next
            curr=temp  
        return root
