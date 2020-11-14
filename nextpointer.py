"""
    Time : O(N)
    Space : 0(1)
    Leetcode : Yes
    Explanation : Through dfs, move to each node 
    then, node.left->node.right and node.right->node.next.left
"""


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        # Keep it to preorder because you want
        # to deal with the root first then move on to other roots
        def inorder(root):
            
            if root and root.left and root.right:       
                root.left.next = root.right
                if(root.next):
                    root.right.next = root.next.left
                inorder(root.left)
                inorder(root.right)
        
        inorder(root)
        return root