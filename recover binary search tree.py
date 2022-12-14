# TC:O(N)
# SC: O(1)

#In this solution we have tried to first store all the nodes into an list and then sorted it according to it's value.
#Once sorted we are trying to map the values in temp with the sorted one. 

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
        self.temp=[]
        def helper(node):
            if not node:
                return
            helper(node.left)
            self.temp.append(node)
            helper(node.right)

        helper(root)

        sor=sorted(n.val for n in self.temp)
        #print(sor)

        for i in range(len(sor)):
            self.temp[i].val=sor[i]


