#Problem2: Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)
# Time complexity: O(n),We visit every node in the tree exactly one time to set its next pointer, so the work grows in a straight line with the number of nodes
# Space complexity: O(1),We only use two pointers called level and current to move around the tree
# Approach:
# We start at the root and treat it as the first level
# On each level we use the next pointers that are already set from the level above to walk across that level from left to right
# For each node we connect its left child to its right child, since they share the same parent
# Then if that node has a neighbor on its right, we connect its right child to the neighbor's left child
# Once we finish connecting a whole level, we move down to the leftmost node of the next level and repeat
# We stop when we reach the leaf level, since leaves have no children to connect

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
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # if the tree is empty there is nothing to connect, so we return None right away
        if root is None:
            return None
        
        # level points to the leftmost node of the level we are currently connecting, we start at the root since it is the only node on level one
        level = root
        # keep going down one level at a time as long as the leftmost node has a left child, meaning there is a level below us
        while level.left is not None:
            # current is a pointer that walks across the current level from left to right using next pointers we already set
            current = level
            # keep walking until we pass the last node on this level
            while current is not None:
                # connect the left child to the right child since both children belong to the same parent
                current.left.next = current.right

                # if this node has a neighbor to its right on the same level
                if current.next is not None:
                    # connect this node's right child to the neighbor's left child, this joins two different parents together
                    # connect this node's right child to the neighbor's left child, this joins two different parents together
                    current.right.next = current.next.left
                
                # move current to the next node on this level using the next pointer we already know is set
                current = current.next
            # move level down to the leftmost node of the next level, so the outer loop can connect that level next
            level = level.left
        
        # return the original root, now fully connected
        return root