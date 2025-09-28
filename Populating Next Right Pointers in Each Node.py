#  Time Complexity : O(N) 
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code connects each node in a perfect binary tree to its immediate right neighbor using constant space. For each level, it links a node’s left child to its right child, and if the node has a next neighbor, it also connects the current node’s right child to that neighbor’s left child. It then moves down one level (level = level.left) and repeats the process until all levels are connected.

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # TC:O(N)    SC: O(1)
        if root is None:
            return None

        level = root

        while level.left is not None:
            curr = level

            while curr is not None:
                curr.left.next = curr.right

                if curr.next is not None:
                    curr.right.next = curr.next.left
                
                curr = curr.next
            
            level = level.left
        
        return root