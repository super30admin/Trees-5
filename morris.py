# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# implemented all three solutions - iterative, recursive and morris inorder traversal. We keep the predecesor node to keep track of the root after traversing the left side of the root
# we come back to this and go to the right side once left is done. 
class Solution(object):
    
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # recursive
        # res=[]
        # def inorder(root):
        #     if not root:
        #         return
        #     inorder(root.left)
        #     res.append(root.val) 
        #     inorder(root.right)
        #     # return res
        # inorder(root)
        # return res

        # iterative
        # res=[]
        # curr=root
        # stack=[]
        # while curr or stack:
        #     while curr:
        #         stack.append(curr)
        #         curr=curr.left
        #     curr=stack.pop()
        #     res.append(curr.val)
        #     curr=curr.right
        # return res

        # moriss inorder space is O(1), time is O(n) [O(1) for finding predecessor and then O(n) for traversing]
        res=[]
        curr=root
        if not root:
            return res
        while(curr is not None):
            if(curr.left is None):
                res.append(curr.val)
                curr=curr.right
            else:
                pre=curr.left
                while(pre.right is not None and pre.right!=curr):
                    pre=pre.right
                
                if(pre.right == curr):
                    pre.right=None
                    res.append(curr.val)
                    curr=curr.right
                else:
                    pre.right=curr
                    curr=curr.left
        return res

