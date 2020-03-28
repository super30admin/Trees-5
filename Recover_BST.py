// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we do inorder traversal and as it is iteration we use a stack to store the order of occurences.we also maintain a node called prev to keep track of prev node.As it is a BST when we do a inorder elements are arranged in ascending order.so when compare with prev.current value should always be greater than prev value.Else we found the place where there is misalignment with node.In the same way we do the remaining values in the tree and find both the nodes.we then swap both the node values.

# Iteration
# Time complexity --> o(n)
# space complexity --> o(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        cursor=root.left
        prev=TreeNode(float('-inf'))
        first=None
        second=None
        stack=[root]
        while cursor!=None or len(stack)!=0:
            while cursor!=None:
                stack.append(cursor)
                cursor=cursor.left
            cursor=stack.pop()
            if first==None and prev.val>cursor.val:
                first=prev
            if first!=None and prev.val>cursor.val:
                second=cursor
            prev=cursor
            cursor=cursor.right
        first.val,second.val=second.val,first.val
        return root
        
        
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
As it is a BST we do an inorder traversal to check if elements are in ascending order or not.Then we can find where there is an mismatched node.During the inorder traversal we check with the prev element if there are in order or not.If not we store the node address and then continue with the remaining nodes.when the node address for both the nodes is found then swap the values of these nodes.
# Recursion
# Time complexity --> o(n)
# space complexity --> o(logn)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.prev=TreeNode(float('-inf'))
        self.first=None
        self.second=None
    def helper(self,cursor):
        if cursor==None:
            return
        self.helper(cursor.left)
        if self.first==None and self.prev.val>cursor.val:
            self.first=self.prev
        if self.first!=None and self.prev.val>cursor.val:
            self.second=cursor
        self.prev=cursor
        self.helper(cursor.right)
        
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if root==None:
            return []
        cursor=root
        self.helper(cursor)
        print(self.first.val,self.second.val)
        self.first.val,self.second.val=self.second.val,self.first.val
        return root
        
        
        
        