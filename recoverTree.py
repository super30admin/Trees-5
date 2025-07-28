# TimeComplexity:O(n)
# SpaceComplexity:O(1)
# Approach:followed inorder traversal use recursion or stack





################
# Similar to inorder traversal but every time we maintain 2 val prev and curr and compare them
################




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
        prev=None
        first,second=None,None
        st=[]
        while( root!=None or len(st)):
                while( root!=None ):
                    print(root.val)
                    st.append(root)
                    root=root.left
                root=st.pop()
                if prev!=None and prev.val>root.val and first==None:
                    first=prev
                    second=root
                elif prev!=None and prev.val>root.val and first !=None:
                    second=root
                prev=root
                root=root.right
        first.val,second.val=second.val,first.val
    





################
# This is using in order traversal
################

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
        self.prev=float('-inf')
        self.first,self.second=None,None
        def inor(root):
            if not root:return 

            inor(root.left)
            if self.prev!=float('-inf') and self.prev.val>root.val and self.second==None:
                self.first,self.second=root,self.prev #swap first and second
            elif self.prev!=float('-inf') and  self.prev.val>root.val and self.second!=None:
                self.first=root
            self.prev=root
            inor(root.right)
        
        inor(root)
        self.first.val,self.second.val=self.second.val,self.first.val
        # print(self.first.val,self.second.val)

            
        
