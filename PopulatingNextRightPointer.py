# TC:O(N)- Since we are are traversing all the nodes for establishing the next pointers. 
# SC: O(1) since we do not use any extra space.


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: 
            return
        
        level = root
        while level.left: 
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next: 
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        
        return root
                
