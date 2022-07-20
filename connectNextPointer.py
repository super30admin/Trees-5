# Approach: # Using BFS
# TC : O(N) as we traverse all the levels and process all of the nodes
# SC : O(1)
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
        
        if not root:
            return None
        
        curr = level = root
        
        while level.left != None:
            curr.left.next = curr.right
            if curr.next:
                curr.right.next = curr.next.left
                curr = curr.next
            else:
                level = level.left
                curr = level
            
        return root

# Approach: # Using DFS
# TC : O(N) as we traverse all the levels and process all of the nodes
# SC : O(N) Stack space

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
        if not root:
            return None

        def dfs(left, right):
            # base
            # if left is none that means right will also be none as this
            # is a complete binary tree
            if not left:
                return None
            # logic
            # for each call we set left.next to right
            left.next = right
            # and then call dfs on all possible combinations
            dfs(left.left, left.right)
            # this left.right and right.left call is where we are connecting
            # nodes in two different subtrees
            dfs(left.right, right.left)

            dfs(right.left, right.right)
            

        dfs(root.left, root.right)
        return root


# Approach: # Using DFS
# TC : O(N) as we traverse all the levels and process all of the nodes
# SC : O(N) Stack space

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
        if not root:
            return None

        def dfs(node):
            # base
            # if node doesn't have left child, it surely won't have right
            # as its a complete binary tree
            if not node.left:
                return None
            
            # logic
            # for each node we link its left child to right child
            node.left.next = node.right
            # and if the node has a next pointer then we can link more
            if node.next:
                node.right.next = node.next.left
            
            # once we are done linking then call recursion
            dfs(node.left)
            dfs(node.right)
            

        dfs(root)
        
        return root