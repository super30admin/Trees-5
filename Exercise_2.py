#Time Complexity : O(NlogN), N being the number of values in tree
#Space Complexity : O(N), N being the number of values in tree. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Tried to do one without sorting at first but 
#didn't work before settling on a sorting.  
'''In order recursion to place node into an array. Then, sort the values of array. The two values
that are different will be switched. 
'''
class Solution:
    def __init__(self):
        self.temp=0
        self.odd=[]
        self.inorder=[]
        self.inorder_val = []
    def inorder_append(self, node):
        if node:
            self.inorder_append(node.left)
            self.inorder.append(node)
            self.inorder_append(node.right)
    def test(self, index):
        left = self.inorder[index]
        middle = self.inorder[index+1]
        right = self.inorder[index+2]
        if left.val<right.val:
            if left.val>middle.val or middle.val>right.val:
                self.odd.append(middle)

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder_append(root)
        for i in range(len(self.inorder)):
            self.inorder_val.append(self.inorder[i].val)

        self.inorder_val.sort()
        for i in range(len(self.inorder)):
            if self.inorder[i].val!=self.inorder_val[i]:
                self.odd.append(self.inorder[i])

        if len(self.odd)>0:
            node1=self.odd[0]
            node2=self.odd[1]
            temp = node1.val
            node1.val=node2.val
            node2.val=temp
        
            
            
