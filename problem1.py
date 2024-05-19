#Time Complexity : O(n)
#Space Complexity : O(1)
#Any problem you faced while coding this : -

#The approach is to use level order traversal. For the current level, make right pointer connection for the below level. Go to the leftmost node and point the next pointer to the current node's right pointer. And for the rightmost next node, point it current node's leftmost node.

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return None
        
        level = root
        while level.left != None:
            curr = level
            while curr != None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            
            level = level.left

        return root

        