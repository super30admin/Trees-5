"""
FAANMG Problem #105 {Medium} 

116. Populating Next Right Pointers in Each Node


# Time complexity : O(n) -- traversing all nodes
# Space complexity : O(n) --> queue

Did this code successfully run on Leetcode : Yes

BFS Solution
Using queue


@name: Rahul Govindkumar_RN27JUL2022
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        #check for root is null
        if not root:
            return None
        
        #initialize queue fro BFS
        q = deque()
        
        q.append(root)
        
        while q:
            
            #for each level prev is set to Null
            prev = None
            
            #traversing node at each level
            for i in range(len(q)):
                
                #Current Node
                curr = q.popleft()
                
                #add the next pointed only if curr is not Null nad Prev is not null
                if curr and prev:
                    #point the left node to right
                    prev.next = curr
                    
                #move prev pointer
                prev =curr
                
                
                #Add child nodes to the queue
                if curr.left:
                    q.append(curr.left)
                    
                if curr.right:
                    q.append(curr.right)
                    
        return root
            
    
"""
FAANMG Problem #105 {Medium} 

116. Populating Next Right Pointers in Each Node


# Time complexity : O(n) -- traversing all nodes
# Space complexity : O(1) --> queue

Did this code successfully run on Leetcode : Yes

BFS Solution
Without Queue


@name: Rahul Govindkumar_RN27JUL2022
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        #check for root is null
        if not root:
            return None
        
        # maintain the root as level for traversing
        level = root
        
        while level.left:
            
            #at each level, we maintain the curr as the root
            curr = level
            
            #traversing node at each level
            while curr:
                
                #point the left of the curr to the right (lower level)
                curr.left.next = curr.right
                
                # if next current is not None, then place a pointer from right of curr to left of next node
                if curr.next:
                    curr.right.next = curr.next.left
                    
                # increment the curr to next node in the same level
                curr = curr.next
            # after traversing all the nodes in a level, increment the level
            level = level.left

        # after doing modifications, we return root
        return root    

            
"""
FAANMG Problem #105 {Medium} 

116. Populating Next Right Pointers in Each Node


# Time complexity : O(n) -- traversing all nodes
# Space complexity : O(H) -

Did this code successfully run on Leetcode : Yes

DFS Solution
With Two Pointer left And right


@name: Rahul Govindkumar_RN27JUL2022
"""            

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution:
    
    def helper(self,leftNode,rightNode):
        
        #base
        # if left or right is None, then return from there
        if leftNode == None:
            return
        
        
        #logic
        # make the left's next as the right
        leftNode.next = rightNode
        
        # recusrively call the left side first for all sub-trees
        self.helper(leftNode.left,leftNode.right)
        
        # recusrively call the left side first for all sub-trees
        self.helper(leftNode.left,leftNode.right)
        
        # recusively call the right of left sub-tree and left of right sub-tree
        self.helper(leftNode.right, rightNode.left)
        
        # recursively call the right side for all the sub-trees
        self.helper(rightNode.left, rightNode.right)
        
        
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        #check for root is null
        if not root:
            return None

        # pass two parameters as root.left and root.right
        self.helper(root.left, root.right)        
        
        # after doing modifications, we return root
        return root    

            
            

    """
FAANMG Problem #105 {Medium} 

116. Populating Next Right Pointers in Each Node


# Time complexity : O(n) -- traversing all nodes
# Space complexity : O(H) -

Did this code successfully run on Leetcode : Yes

DFS Solution
With One Pointer Curr Node (  Iterative Sol )


@name: Rahul Govindkumar_RN27JUL2022
"""


"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution:
    
    def helper(self,node):
        
        #base
        # if left or right is None, then return from there
        if node.left == None:
            return
        
        
        #logic
        # make a pointer for root's left to root's right
        #point the left of the curr to the right (lower level)
        node.left.next = node.right
        
        # if next element of node is not None
        if node.next:
            # make a link between node's right to next node's left
            node.right.next = node.next.left

        # recursively call the tree on the left and right
        self.helper(node.left)
        self.helper(node.right)
      
        
        
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        #check for root is null
        if not root:
            return None

        # pass root
        self.helper(root)        
        
        # after doing modifications, we return root
        return root    

            
            
        
        
        
               
        
        
               
        
        
            