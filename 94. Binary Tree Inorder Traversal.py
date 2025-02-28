#regular dfs
#space: O(h)
#time: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.traversal_list= list()
        self.dfs(root)
        return self.traversal_list
    def dfs(self,root):
        if root is None:
            return root
        self.dfs(root.left)
        self.traversal_list.append(root.val)
        self.dfs(root.right)
        return root
#iterative approach
#space: O(n)
#Time: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        q= []
        final_list= list()
        
        curr= root
        while len(q) !=0 or curr is not None:
            
            while curr is not None:
                q.append(curr)
                curr=curr.left
            curr= q.pop()
            final_list.append(curr.val)    
            curr= curr.right

        return final_list
        
        
