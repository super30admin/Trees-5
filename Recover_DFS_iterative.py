# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

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
        # check if root is None
        if not root:
            return 
        # flag to check for the first breach
        flag = False
        
        # first and second is used to store the TreeNode of the elements that needs to be swapped
        
        prev = None
        st = []
        # insert the nodes into stack until we reach the left most
        while root or st:
            while root != None:
                st.append(root)
                root = root.left
            # make root as the leftmost node
            root = st.pop()
            
            # if prev is not None and prev is greater than root
            if prev != None and prev.val > root.val:
                # check for flag, if first breach, then assign first and second as prev and root(curr)
                if not flag:
                    flag = True
                    first = prev
                    second = root
                # when the second element is found, only update the curr
                second = root
            
            # maintain the prev as root
            prev = root
            
            # moving to the right node
            root = root.right
            
        
        # swap only the values
        temp = first.val
        first.val = second.val
        second.val = temp
