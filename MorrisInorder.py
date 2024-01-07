class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        li = []
        if(root == None):
            return li
        curr = root
        while(curr != None):
            if(curr.left == None):
                li.append(curr.val)
                curr = curr.right

            else:
                rightmost = curr.left
                while(rightmost.right != None and rightmost.right != curr):
                    rightmost = rightmost.right
                    if(rightmost.right == None):
                        rightmost.right = curr
                        curr = curr.left
                    else:
                        li.append(curr.val)
                        rightmost.right = None
                        curr = curr.right
        return li
