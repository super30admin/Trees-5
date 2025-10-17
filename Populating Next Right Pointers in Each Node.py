"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
'''
Solution 1: BFS - level order using queue
    - Do a BFS on the tree.
    - At each level, pop the node and point it's next to top of the queue except 
      when we are at last node at this level.
    - Add left and right child of the popped parent node to the queue, if they
      exists
Time Complexity: O(N)
Space Complexity: O(N/2),  Queue will have max size at last level = leaf nodes 
'''
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root==None: # Edge Case: empty tree
            return root

        bfs_queue = deque()
        bfs_queue.append(root)

        while bfs_queue:
            size = len(bfs_queue)
            for k in range(size):
                parent = bfs_queue.popleft()
                if k!=size-1: # untill second last node at this level, update next
                    parent.next = bfs_queue[0]
                if parent.left!=None:
                    bfs_queue.append(parent.left)
                if parent.right!=None:
                    bfs_queue.append(parent.right)
        
        return root

'''
Solution 2: Level order without queue
    - Maintain a level pointer. 
    - Each level behaves as a linkedList. 
    - while iterating at this level, build a linkedList among the next level nodes.  
Time Complexity: O(N)
Space Complexity: O(1),   
'''
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root==None: # Edge Case: empty tree
            return root

        current_level = root 
        while current_level.left!=None: # we go until second last level
            node = current_level # appoint the head of at this level. 
            while node!=None: # this iterates through the nodes at this level, as if linkedList
                node.left.next=node.right # for current parent, point left child -> right child
                if node.next!=None: # if there are more nodes at this level
                    node.right.next = node.next.left # point parent's right child to next node's left child
                node = node.next # move further at this level
            current_level = current_level.left # move to the next level
        
        return root