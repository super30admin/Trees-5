'''
116 Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.  Initially, all next pointers are set to NULL.

Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Example 2:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 212 - 1].
-1000 <= Node.val <= 1000

Follow-up:
You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

Solution:
1. BFS (Level Order Traversal) using queue: (least optimal)
Perform level order traversal tracking size of each level. For each kth node (k>1) at some level L, set prev.next = node, where prev is the previous node
At the end of last node at each level, set node.next = None.

https://youtu.be/wNGPqQNiHt8?t=2921
Time: O(N), Space: O(diameter of tree) = O(N)

2. Smart BFS (Level Order Traversal): (most optimal)
Here, we don't need to use a queue. Instead we use only the left child at each level thereby making space complexity as O(1).
  _1_
 /   \\
 2    3
/ \  / \\
4 5  6  7
Step 0: Set root = 1
From root (1), connect 1.left to 1.right by setting
Step 1: root.left.next = root.right.
Now, 2 and 3 are connected (2->3)

Step 2: Then go to root's left child.
If the left child doesn't exist, we have reached the end.
If the left child exists, let the new root = left child
Repeat Step 1.
2.left.next = 2.right (4->5 are connected)

Step 3: Also, connect 5->6
2.right.next = 2.next.left (5->6)

Step 4: Now go to the root.next node (3). The next node becomes the new root. Repeeat Step 1.
3.left.next = 3.right (6->7)

Step 5: Go to Step 2.

https://youtu.be/wNGPqQNiHt8?t=3458
Time: O(N), Space: O(1)

3. DFS: (sub-optimal)
We use two pointers to connect the left and right children at each level. Then we connect across subtrees by linking the right child of one node to the left child of the next.  This is done recursively across all levels.
https://youtu.be/wNGPqQNiHt8?t=4344
Time: O(N), Space: O(H)
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from typing import Optional
from binary_tree import *

def connect_bfs1(root: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
    ''' Time: O(N), Space: O(diameter of tree) = O(N) '''
    if not root:
        return None
    q = deque()
    q.append(root)
    prev = root
    while q:
        sz = len(q)
        for i in range(sz):
            curr = q.popleft()
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
            if i != 0:
                prev.next = curr
            prev = curr
        prev.next = None # this statement is not reqd since by default 'next' of TreeNextNode is set to None
    return root

def connect_bfs2(root: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
    ''' Time: O(N), Space: O(1) '''
    if not root:
        return None
    left = root
    while left:
        curr = left
        while curr:
            if curr.left: # curr is not a leaf node
                curr.left.next = curr.right
                if curr.next: # curr is not the last node in the current level
                    curr.right.next = curr.next.left
            curr = curr.next
        left = left.left
    return root

def connect_dfs(root: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
    ''' Time: O(N), Space: O(1) '''
    def dfs(left: Optional[TreeNextNode], right: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
        if left is None:
            return
        left.next = right
        dfs(left.left, left.right)
        dfs(left.right, right.left)
        dfs(right.left, right.right)

    if not root:
        return None
    dfs(root.left, root.right)
    return root


def run_connect():
    tests = [ ([1,2,3,4,5,6,7], [1,None,2,3,None,4,5,6,7,None]),
              ([1], [1, None]),
              ([], []),
    ]
    for test in tests:
        root, ans = test[0], test[1]
        print(f"\nPerfect BT")
        if root:
            tree=build_tree_level_order_TreeNextNode(root)
            tree.display()
        else:
            tree = None
        print(f"root = {root}")
        for method in ['bfs1', 'dfs2', 'dfs']:
            if method == 'bfs1':
                tree = connect_bfs1(tree)
            elif method == 'bfs2':
                tree = connect_bfs2(tree)
            elif method == 'dfs':
                tree = connect_dfs(tree)
            connect_bt = levelOrderTraversal_TreeNextNode(tree)
            print(f"Method {method}: connect_bt = {connect_bt}")
            success = (ans == connect_bt)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_connect()