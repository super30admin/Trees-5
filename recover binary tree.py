# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# inroder traverse in tree and find the breach. Use first and second pointer to store breaches.
# since breaches can be at same place :  upadate first and second 
# if we found breach away we just update second
# swap

class Solution:
    def __init__(self):
        self.prev = None
        self.first = None
        self.second = None
        
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        stack = deque()
        l=[]
        prev = None
        first = None
        second = None
        
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev != None and root.val < prev.val:
                if first == None:
                    first = prev
                    second = root
                else:
                    second = root
            prev = root
            root = root.right
        
        temp = first.val
        first.val = second.val
        second.val = temp
            
        
        
        
        
# Recursive    
#         self.prev = None
#         self.first = None
#         self.second = None
        
#         def helper(root):
#             if root:
#                 helper(root.left)
#                 if self.prev != None and root.val<self.prev.val:
#                     if self.first == None:
#                         self.first = self.prev
#                         self.last = root
#                     else:
#                         self.last = root
#                 self.prev = root   
#                 helper(root.right)
                
        
#         helper(root)
#         temp = self.first.val
#         self.first.val = self.last.val
#         self.last.val = temp