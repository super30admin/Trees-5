# Time Complexity :
# O(N)

# Space Complexity :
# O(H)

# Did this code successfully run on Leetcode :
#Yes

#We do an inorder traversal of the tree. We record and compare the current value and previous value. In an inorder traversal, the current should always be larger than previous. 
#So when the current is smaller than the prev, there is a mismtach and needs to be corrected. If there is no other mismtach in the tree, we will swap these values and we recover the binary tree
#If a second mismtach happens (there can be maximum 2 when 2 elements are swapped), we will swap the current element with the prev element (stored in second) first mismatch 

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None :
            return
        self.prev = None
        self.first = None
        self.second = None 
        self.inorder(root)
        
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
    
    def inorder(self,root):
        if root == None:
            return
        self.inorder(root.left)
        if self.prev != None and root.val <= self.prev.val :
            if self.first == None :
                self.first = root
                self.second = self.prev
            else :
                self.first = root

        self.prev = root

        self.inorder(root.right)
