# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Stack-based Iterative Solution:
    # TC: O(N)
    # SC: O(h)

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return
        prev = None # track the last node scanned
        first = None # track the first mismatch
        sec = None # track the 2nd mismatch
        stack = list()
        count = 0

        while((root is not None) or (len(stack)!=0)):
            while root is not None:
                stack.append(root)
                root = root.left

            root = stack.pop()

            if((prev is not None) and (prev.val>root.val)):
                count+=1
                #the case where there is only one mismatch
                # i.e. the sec is a mismatch and a direct
                if first is None:
                    first = prev
                sec = root

            prev = root

            if count==2:
                break
            root = root.right

        first.val,sec.val = sec.val,first.val

    # Recursive Solution:
    # TC: O(N)
    # SC: O(h)
    # def __init__(self):
    #     self.prev = None
    #     self.first = None
    #     self.sec = None
    #     self.count = 0 # to keep track of number of mismatches

    # def recoverTree(self, root: Optional[TreeNode]) -> None:
    #     """
    #     Do not return anything, modify root in-place instead.
    #     """
    #     if root is None:
    #         return

    #     self.dfs(root)
    #     self.first.val,self.sec.val = self.sec.val,self.first.val

    # def dfs(self,root):
    #     if root is None:
    #         return

    #     if self.count<2:
    #         self.dfs(root.left)

    #     if((self.prev is not None) and (self.prev.val>root.val)):
    #         self.count+=1
    #         if self.first is None:
    #             self.first = self.prev
    #         self.sec = root
    #     self.prev = root

    #     if self.count<2:
    #         self.dfs(root.right)