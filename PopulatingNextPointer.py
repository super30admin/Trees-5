"""
The approach here is to have a next pointer and from the root node point the next pointer at the level
below the root to it's right child, like this for a current node we join it's left and right childs by doing
the above mentioned rule, for joining nodes from diffrent parents we use the already connected above level
nodes to maintain and change next pointers, we make the right pointer of curr node point to the left node of
the cur.next node. This way we connect two nodes with un-common parents.
LeetCode - Running
Space Complexity - O(N)
"""
def connect(self, root):
    if not root:
        return None
    cur  = root
    next = root.left

    while cur.left :
        cur.left.next = cur.right
        if cur.next:
            cur.right.next = cur.next.left
            cur = cur.next
        else:
            cur = next
            next = cur.left
    return root