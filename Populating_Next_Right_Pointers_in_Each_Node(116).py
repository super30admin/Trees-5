"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution:
    # TC: O(N)
    # SC: O(1)
    # Here we connect the child nodes at every node i.e. the level below
    # and since we have already connected the nodes at the current level
    # we dont need to store the nodes in a queue
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return

        curr = root
        nxt = root

        #since we are connecting nodes on the lower level, when nxt is none we have reached
        # the leaf nodes and they dont have any children so we dont need to traverse
        while(nxt.left is not None):
            nxt = curr.left
            while curr is not None:
                curr.left.next = curr.right
                if curr.next is not None:
                    curr.right.next = curr.next.left

                curr = curr.next
            # we have reached the rightmost node on that level
            curr = nxt

        return root

    #Solution A
    # def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
    #     if root is None:
    #         return

    #     curr = root
    #     nxt = root.left

    #     while((curr is not None) and (nxt is not None)):
    #         curr.left.next = curr.right
    #         if curr.next is not None:
    #             curr.right.next = curr.next.left

    #         curr = curr.next
    #         if curr is None: # we have reached the rightmost node on that level
    #             curr = nxt
    #             nxt = curr.left

    #     return root