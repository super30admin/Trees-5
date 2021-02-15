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
        '''
        Time, Space Complexity: O(n)
        
        '''
        
        nums = []
        
        def inorder(root):
            if(root==None):
                return
            inorder(root.left)
            nonlocal nums
            nums.append(root)
            inorder(root.right)
        
        inorder(root)
        x = y = -1
        
        
        for i in range(0,len(nums)-1):
            if nums[i + 1].val < nums[i].val:
                y = nums[i + 1]
            # first swap occurence
                if x == -1:     
                    x = nums[i]
            # second swap occurence
            
        x.val,y.val = y.val,x.val
