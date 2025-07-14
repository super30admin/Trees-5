"""
Approach:
- Use Level Order Traversal (BFS) with a queue to connect each node's `next` pointer to its right neighbor.
- Store (node, level) in the queue.
- If the current level matches the last level, link last.next = current node.
- At each level, update `last` to current node.

Time Complexity: O(n) — visit each node once
Space Complexity: O(n) — worst case for queue storage at the widest level
"""
from collections import deque
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        q = deque([(root,0)])
        last, last_level = None, -1
        while q:
            node, lvl = q.popleft()
            if not node:
                return root
            if last_level == lvl:
                last.next = node
            last, last_level = node, lvl
            q.append((node.left, lvl +1))
            q.append((node.right, lvl +1))

def build_perfect_binary_tree():
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n4 = Node(4)
    n5 = Node(5)
    n6 = Node(6)
    n7 = Node(7)

    n1.left = n2; n1.right = n3
    n2.left = n4; n2.right = n5
    n3.left = n6; n3.right = n7

    return n1


def print_levels_with_next(root):
    level = 0
    q = deque([(root, 0)])
    curr_level_nodes = []
    while q:
        node, lvl = q.popleft()
        if lvl != level:
            print(" -> ".join(str(n.val) for n in curr_level_nodes) + " -> None")
            curr_level_nodes = []
            level = lvl
        curr_level_nodes.append(node)
        if node.left:
            q.append((node.left, lvl + 1))
        if node.right:
            q.append((node.right, lvl + 1))
    if curr_level_nodes:
        print(" -> ".join(str(n.val) for n in curr_level_nodes) + " -> None")


def main():
    root = build_perfect_binary_tree()
    Solution().connect(root)
    print("Levels with `next` pointers:")
    print_levels_with_next(root)


if __name__ == "__main__":
    main()