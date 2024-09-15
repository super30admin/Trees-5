
'''
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
Did it run leetcode: Yes
Did you face any problem: No

Time Complexity: 0(N)
Space Complexity: 0(H)

Algorithm:
- Make a bfs traversal of the tree
- At every level traverse the node and make pevious node point to the right.

'''

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        def bfsTraversal(level):
            if not level:
                return
            queue = []
            for node in level:
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            for i in range(len(queue)-1):
                queue[i].next = queue[i+1]
            bfsTraversal(queue)
        
        if not root:
            return 
        else:
            bfsTraversal([root])
            return root