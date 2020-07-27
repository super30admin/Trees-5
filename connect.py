#116. Populating Next Right Pointers in Each Node
# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        # dfs
        if not root:
            return
        # if root has non-empty right pointer, it means root must have left pointer and we need to link left -> right through next pointer
        if root.right:
            root.left.next = root.right
			# if root has non-empty next pointer (means not point to NULL), it means we are linking left subtree and right subtree together
			# so their left and right subtree also need to be linked together just like in the example 1:
			# when we link 2->3, we also need to link their subtrees through 5 -> 6 (5: 2.right,  ->: next, 6: 2.next.left )
            if root.next:
                root.right.next = root.next.left
                
        self.connect(root.left)
        self.connect(root.right)
        
        return root 