# // Time Complexity : O(n)
# // Space Complexity : O(1) ,since recursive stack is not cosidered in space as per this question 
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No

class Solution:
    def connect(self, root, n = None):
        if not root: return 
        root.next = n
        
        # for Nodes on left of parents
        self.connect(root.left, root.right)
        
        # for nodes right of parents
        self.connect(root.right, n.left if n else None)
        
        return root