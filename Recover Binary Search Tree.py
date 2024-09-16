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
        #Approcah: Iterative inorder traversal
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, n and h are the size and height of the tree, respectively
        
        first = None
        second = None
        flag = False
        
        prev = None
        
        st = []
        while st or root:
            while root:
                st.append(root)
                root = root.left
            
            root = st.pop()
            if prev != None and prev.val > root.val:
                if not flag:
                    first = prev
                    second = root
                    flag = True
                else:
                    second = root
            prev = root
            
            root = root.right
        
        first.val, second.val = second.val, first.val
        return
    
    '''
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #Approcah: Recursive inorder traversal
        #Time Complexity: O(n)
        #Space Complexity: O(h)     // under the hood
        #where, n and h are the size and height of the tree, respectively
        
        first = None
        second = None
        flag = False
        
        prev = None
        
        def helper(root):
            nonlocal first, second, flag, prev
            #base
            if not root:
                return
            
            #logic
            helper(root.left)
            
            if prev != None and prev.val > root.val:
                if not flag:
                    first = prev
                    second = root
                    flag = True
                else:
                    second = root
            prev = root
            
            helper(root.right)
        
        helper(root)
        
        first.val, second.val = second.val, first.val
        return
    '''