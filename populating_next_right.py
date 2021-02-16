# Time Complexity : O(n)
# Space Complexity : O(n) considering stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I do inorder traversal where I send the right child to left inorder traversal and to each right inorder I send right child's left. I send None the the 
# rightmost path

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        def inorder(root, link):
            if not root.left and not root.right:
                return 
            
            inorder(root.left, root.right) 
            root.left.next = root.right
            if link:
                root.right.next = link.left
                inorder(root.right,link.left)
            else:
                inorder(root.right,None)
        
        if not root: return None
        inorder(root, None)  
        return root
