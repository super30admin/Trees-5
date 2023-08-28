#Time Complexity : O(Nxh), N being the number of values in tree and h being the height of the tree. 
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Minor node issues. 
'''For each node, create all links below it. Use recursion to create links for each node.  
'''

class Solution:
    # recursion to create all links below node. 
    def helper(self, left, right):
        if left.right and right.left:
            left.right.next = right.left
            self.helper(left.right, right.left)

    # Create all links below node. 
    def link(self, root):
        if root.left and root.right:
            root.left.next = root.right
            self.helper(root.left, root.right)
            
    # recurse through all nodes. 
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root:
            self.connect(root.left)
            self.link(root)
            self.connect(root.right)
        return root