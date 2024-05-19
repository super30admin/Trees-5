#Time Complexity : O(n)
#Space Complexity : O(1)
#Any problem you faced while coding this : -

#The approach is to replicate the recursion flow with the help of a predecessor node. While traversing down, we focus on the rightmost node of the current node's left node. Then we build a connection between the rightmost node and the current node. Then we again traverse back to current and remov eth connection while going up to retain the same structure of the tree.

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        curr = root
        while curr != None:
            if curr.left == None:
                result.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right != None and pre.right != curr:
                    pre = pre.right

                if pre.right == None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    result.append(curr.val)
                    curr = curr.right  
            
        return result