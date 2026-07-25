
## Problem3 Morris Inorder Traversal (https://leetcode.com/problems/binary-tree-inorder-traversal/)
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        """
        Morris Inorder Traversal
        
        Time Complexity: O(N)
        Even though there is a nested while loop, every edge in the binary tree is 
        traversed at most 3 times. Therefore, the time complexity is strictly linear 
        with respect to the number of nodes, N.
        
        Space Complexity: O(1) auxiliary space. 
        Unlike standard iterative (using a stack) or recursive solutions that take 
        O(N) space in the worst case, Morris Traversal modifies the tree structure 
        temporarily by creating "threads" to predecessors to avoid using extra memory, 
        and then restores the tree. The O(N) space used by the `result` array is 
        for the output, which doesn't count towards auxiliary space.
        """
        result = []
        curr = root
        
        while curr is not None:
            # If there is no left child, we can simply visit the current node 
            # and then move to its right child.
            if not curr.left:
                result.append(curr.val)
                curr = curr.right
            else:
                # Find the Inorder Predecessor (IP): the rightmost node in the left subtree.
                ip = curr.left
                while ip.right and ip.right != curr:
                    ip = ip.right
                
                # If the predecessor's right child is null, we create a temporary "thread" 
                # (link) back to the current node. This allows us to return to 'curr' 
                # later without needing a stack. Then, we move to the left child.
                if not ip.right:
                    ip.right = curr
                    curr = curr.left
                
                # If the predecessor's right child is already pointing to 'curr', it means
                # we have already visited the left subtree. We need to break the temporary 
                # thread to restore the original tree structure, visit the current node, 
                # and then move to the right child.
                else:
                    ip.right = None
                    result.append(curr.val)
                    curr = curr.right
                    
        return result