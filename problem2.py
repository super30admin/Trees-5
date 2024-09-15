
#Recover Binary Search Tree

# // Time Complexity :  O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        self.prev, self.first, self.second=None, None, None
        def inorder(root):
            if root==None:
                return
            
            inorder(root.left)                                              #going on an inorder traversal as its a BST and the values should be in ascending order
            
            if(self.prev!=None and self.prev.val>=root.val):                #if prev has been set and its greater than the current node, then we know its out of place
                if(self.first==None):                                       #if first hasnt been set up, set store first as prev
                    self.first=self.prev
                self.second=root                                            #set second as root as it could be the current root, or it could also be another root in the future, which we will catch
            self.prev=root                                                  #set prev to the current root as the root progresses forward
            inorder(root.right)
            
        inorder(root)
        temp=self.first.val                                                 #swap the values
        self.first.val=self.second.val
        self.second.val=temp
        return root