# // Time Complexity : O(V+E)
# // Space Complexity : stack takes up -> O(maxDepth)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 
# Intuition: inorder traversal gets a sorted order. Start iterating over the sorted list, the first problem is encountered when curr element is lesser than the previous element. We can store the curr and prev in two variables and continue iterating. When another pair is encountered, we store the curr and prev again in other two variables. After running through multiple examples, we observe that first pair's curr and second pair's prev values are always in correct order. Hence, we only need to swap the other two elements whenever encountered. 
#Keep track of popped element as x and second's prev as y when the conditions break

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return 
        
        stack = []
        
        prev, x, y = None, None, None

        while stack or root != None:
            while root!= None:
                stack.append(root)
                root = root.left
                
            popped = stack.pop()
            
            if prev!= None and prev.val>popped.val:
                #invalid elements
                x = popped
                if y == None:
                    y = prev
                else:
                    #
                    break
            
            prev = popped
            root = popped.right
            
        #swap the elements
        self.swap(x,y)
            
    
    def swap(self, x: TreeNode, y: TreeNode):
        temp= y.val
        y.val=x.val
        x.val = temp
            
            
            
            
            