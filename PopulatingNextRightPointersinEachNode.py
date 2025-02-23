#Time Complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
#Space Complexity: O(1), since the solution uses constant space without any additional data structures or recursion.
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if(root==None):
            return root
        else:
            curr = root
            nxt = root.left
            while curr and nxt:
                curr.left.next = curr.right
                if(curr.next!=None):
                    curr.right.next = curr.next.left
                curr = curr.next
                if(curr==None):
                    curr=nxt
                    nxt=curr.left
            return root