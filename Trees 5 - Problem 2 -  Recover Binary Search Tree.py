"""
FAANMG Problem #106 {Hard} 

99. Recover Binary Search Tree


# Time complexity : O(n) -- traversing all nodes
# Space complexity : O(H) 

Did this code successfully run on Leetcode : Yes

DFS Inorder Solution


@name: Rahul Govindkumar_RN27JUL2022
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def inorder_dfs(self,node):
            
        #base
        if not node:
            return


        #logic
        self.inorder_dfs(node.left)
        
        
         # check if prev is not None and prev is greater than root, only then we have our element at incorrect place
        if self.prev is not None and  self.prev.val > node.val:
            
            # if this is the first breach, then change flag to True and set the first curr and prev
            if not self.flag:
                self.flag = True
                self. first = self.prev
                self.second= node
                
            # for the other element, we will only update the second
            else:
                self.second= node
        
        # maintain the prev for every node
        self.prev = node

        self.inorder_dfs(node.right)
        
        
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        self.first = None
        self.second = None
                
        self.prev = None
        self.curr = None
        
        self.flag = False
        self.inorder_dfs(root)
        
        self.first.val,self.second.val = self.second.val, self.first.val
        
        
        
"""
FAANMG Problem #106 {Hard} 

99. Recover Binary Search Tree


# Time complexity : O(n) -- traversing all nodes
# Space complexity : O(H) 

Did this code successfully run on Leetcode : Yes

DFS Inorder Iterative Solution


@name: Rahul Govindkumar_RN27JUL2022
"""            
        
        
        
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
     
        
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        first = None
        second = None
                
        prev = None
        curr = None
        
        flag = False
        
        stack=[]
        curr = root
        
        while stack or curr:
            
            while curr:
                stack.append(curr)
                curr = curr.left
                
            curr = stack.pop() 
            
            if prev is not None and  prev.val > curr.val:
                if not flag:
                    flag = True
                    first = prev
                    second = curr
                else:
                    second = curr
                
            prev = curr

            curr = curr.right
        
        
        first.val,second.val = second.val, first.val
        
        
        
            
        
        
        