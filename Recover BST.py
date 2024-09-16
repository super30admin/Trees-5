# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No

class Solution:
    def recoverTree(self, root):
        """
        Do not return anything, modify root in-place instead.
        """
        
        stack = []
        x = y = pred = None
        
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            
            # check if current node value is smaller than previous node for swapped case 
            if pred and root.val < pred.val:
                y = root
                
                # first occurence of swap
                if x is None:
                    x = pred
                    
                # second occurence
                else:
                    break
                    
            pred = root
            root = root.right
    
        # swap the values
        x.val, y.val = y.val, x.val