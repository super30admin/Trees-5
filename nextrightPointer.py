class Node:
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

def connect(root: 'Node') -> 'Node':
    if not root:
        return None

    # Start with the root node
    leftmost = root

    # Traverse levels
    while leftmost.left:
        # Traverse the current level nodes
        head = leftmost
        while head:
            # Connect left child to right child
            head.left.next = head.right
            
            # Connect right child to the next node's left child, if possible
            if head.next:
                head.right.next = head.next.left
            
            # Move to the next node in the current level
            head = head.next
        
        # Move to the next level
        leftmost = leftmost.left

    return root

#time = O(N)
#space = O(1)