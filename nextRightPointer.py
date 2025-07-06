"""
Start at the leftmost node of each level
Connect: node.left.next = node.right and node.right.next = node.next.left (if exists)
Move horizontally across level, then move down to next level
"""
"""
Time Complexity - O(n) – all nodes visited once
Space Complexity - O(1) – extra space
"""


class Node:
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

    def print_levels(self):
        level = self
        while level:
            current = level
            while current:
                print(current.val, end=" , ")
                current = current.next
            print("NULL")
            level = level.left

class nextRightPointer:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None

        leftmost = root
        while leftmost.left:
            head = leftmost
            while head:
                head.left.next = head.right
                if head.next:
                    head.right.next = head.next.left
                head = head.next
            leftmost = leftmost.left

        return root

if __name__ == "__main__":
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    obj = nextRightPointer()
    connected_root = obj.connect(root)
    connected_root.print_levels()


"""
Recursive Version

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None

        if root.left:
            root.left.next = root.right
            if root.next:
                root.right.next = root.next.left

            self.connect(root.left)
            self.connect(root.right)

        return root

"""