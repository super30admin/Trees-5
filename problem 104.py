#  https://leetcode.com/problems/populating-next-right-pointers-in-each-node/


############# BFS - QUEUE ######################

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None
        q = deque()
        q.append(root)
        level = 0
        res = []

        while q:
            len_q = len(q)
            res.append([])
            for _ in range(len_q):
                curr = q.popleft()
                res[level].append(curr)

                if curr.left != None:
                    q.append(curr.left)

                if curr.right != None:
                    q.append(curr.right)
            
            level+=1
        for i in range(len(res)):
            for j in range(len(res[i])):
                if j == len(res[i]) - 1:
                    res[i][j].next = None
                else:
                    res[i][j].next = res[i][j+1]

        return root

# TC: O(n)
# SC: O(n)


"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None
        q = deque()
        q.append(root)
        level = 0
        res = []

        while q:
            len_q = len(q)

            for i in range(len_q):
                curr = q.popleft()
                if i != len_q-1:
                    curr.next = q[0]


                if curr.left != None:
                    q.append(curr.left)
                    q.append(curr.right)
        return root


# TC: O(n)
# SC: O(n)

#############################

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None
        
        level = root

        while level.left != None:
            curr = level
            while curr != None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next

            level = level.left
        
        return root

# TC: O(n)
# SC: O(1)

# leveraging next pointer here and it is a perfect binary tree so equal no of child nodes
# and next pointer is there for all the nodes
# it links the right child of the current node to the left child of the next node 
# at the same level. 
# This is done iteratively using two pointers: level for the current level and 
# curr for iterating through nodes at that level.


######################## DFS - RECURSIVE ######################


"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None
        
        self.dfs(root.left,root.right)
        return root
    
    def dfs(self,left,right):
        if left == None: # I dont even have to check for right because its perfect BT
            return 
        
        left.next = right
        self.dfs(left.left,left.right)
        self.dfs(left.right,right.left)
        self.dfs(right.left,right.right)

# TC: O(n)
# SC: O(h) - rec stack space

# DFS- try and visualize



####################### DFS OPTIMIZED ######################


"""
"""
# Definition for a Node.
"""
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None
        
        self.dfs(root)
        return root
    
    def dfs(self,root):
        if root.left == None: # I dont even have to check for right because its perfect BT
            return 
        
        root.left.next = root.right
        if root.next != None:
            root.right.next = root.next.left
        self.dfs(root.left)
        self.dfs(root.right)

# TC: O(n)
# SC: O(h) - rec stack space

# DFS- try and visualize
# little optimized than before



#####--------------------------------------------------------------------

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None
        
        self.dfs(root)
        return root
    
    def dfs(self,root):
        if root.left == None: # I dont even have to check for right because its perfect BT
            return 
        
        root.left.next = root.right
        self.dfs(root.left)
        if root.next != None:
            root.right.next = root.next.left
        self.dfs(root.right)

# TC: O(n)
# SC: O(h) - rec stack space

# DFS- try and visualize
# little optimized than before

'''
root.left.next = root.right
        if root.next != None:
            root.right.next = root.next.left

this part of the code can't be written in inrder or postorder
but if I place this line
root.left.next = root.right preorder
and these lines anywhere also it will work
        if root.next != None:
            root.right.next = root.next.left

because in a root establishing left next to its corresponding rights is necessary.
'''





