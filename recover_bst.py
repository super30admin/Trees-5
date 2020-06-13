#RECURSIVE SOLUTION


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity:O(n)
#Space Complexity: O(h) for call stack
'''
We know that an inorder traversal of a BST should be sorted, this means we will be able
to identify one an element is out place (curr< prev, prev is misplaced). Either
curr and prev were swaped, or the other swaped element is further. We keep a flag
to say if we've found the first one or not. If so, we point to the second misplaced
element with a pointer. The first misplaced in the traversal is the "too big" one.
The second mistake is the "too small" one. We can keep a second flag to stop the search.

'''
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        first,second=None,None
        flag,prev=False,TreeNode(float("-inf"))
        second_flag=False
        def helper(root):
            nonlocal first,second,flag,prev,second_flag
            if not root or second_flag:
                return
            helper(root.left)
            if root.val<prev.val and not flag:
                first,second,flag=prev,root,True
            elif root.val<prev.val and flag:
                second=root
                second_flag=True
            prev=root
            helper(root.right)
            
        helper(root)
        temp=first.val
        first.val=second.val
        second.val=temp
            
            
            
#Iterative solution
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        first,second=None,None
        flag,prev=False,TreeNode(float("-inf"))
        st=[]
        while st or root:
            while root: #recurse root.left
                st.append(root)
                root=root.left
            root=st.pop()
            
            if root.val<prev.val and not flag:
                first,second,flag=prev,root,True
            elif root.val<prev.val and flag:
                second=root
                break
            prev=root
            #recurse(root.right)
            root=root.right
            
        temp=first.val
        first.val=second.val
        second.val=temp
