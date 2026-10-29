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
Here, we don't need to use queue to store the nodes.
Instead we use an iterative solution that doesn't require any storage (space O(1))
  _1_
 /   \\
 2    3
/ \  / \\
4 5  6  7
Step 0: Set root = 1
From root (1), connect 1.left to 1.right by:

Step 1: root.left.next = root.right.
Now, 2 and 3 are connected (2->3)

Step 2: Since there are no other nodes after root at the same level,
go to left of root by setting root = root.left
E.g. root = 1.
root = root.left = 2

Step 3: If the root's left child doesn't exist, root is a child node.
If the left child exists, the right child also exists (since it is a perfect BT). Hence, connect the siblings
E.g. 2.left.next = 2.right
Now, siblings 4 and 5 are connected (4->5)

Step 3: Now, connect the cousins
E.g. 2.right.next = 2.next.left
-> 5.next = 3.left
Now, cousins 5 and 6 are connected (5->6)

Step 4: Now go to the root.next node.
- If it is not None, the root.next node becomes the new root. Go to Step 3 (which will connect 6 and 7 using root = 3 root.left.next = root.right (6->7)).
- If it is None, no more nodes to traverse at the same level.

Step 5: Go to Step 2 (one level lower)
Time: O(N), Space: O(1)
https://youtu.be/wNGPqQNiHt8?t=3458

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
from copy import deepcopy as dcp


def connect_bfs1(root: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
    ''' Time: O(N), Space: O(diameter of tree) = O(N) '''
    if not root:
        return None
    q = deque()
    q.append(root)
    while q:
        sz = len(q)
        for i in range(sz):
            curr = q.popleft()
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
            if i != sz - 1:
                curr.next = q[0]
    return root

# works as well
# def connect_bfs1(root: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
#     ''' Time: O(N), Space: O(diameter of tree) = O(N) '''
#     if not root:
#         return None
#     q = deque()
#     q.append(root)
#     prev = root
#     while q:
#         sz = len(q)
#         for i in range(sz):
#             curr = q.popleft()
#             if curr.left:
#                 q.append(curr.left)
#             if curr.right:
#                 q.append(curr.right)
#             if i != 0:
#                 prev.next = curr
#             prev = curr
#         prev.next = None # this statement is not reqd since by default 'next' of TreeNextNode is set to None
#     return root


def connect_bfs2(root: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
    ''' Time: O(N), Space: O(1) '''
    if not root:
        return None
    left = root
    while left:
        curr = left
        while curr: # parent
            if curr.left: # left child is not a leaf node
                curr.left.next = curr.right # connect siblings
                if curr.next: # connect cousins
                    curr.right.next = curr.next.left
                curr = curr.next
        left = left.left # go to left most node in next lower level
    return root

def connect_dfs(root: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
    ''' Time: O(N), Space: O(H) '''
    def dfs(left: Optional[TreeNextNode], right: Optional[TreeNextNode]) -> Optional[TreeNextNode]:
        if left is None:
            return
        # no need to check if right is null or not since
        # it is a perfect BT. If left doesn't exist, then right
        # will not exist for sure.
        left.next = right
        dfs(left.left, left.right)
        dfs(left.right, right.left)
        dfs(right.left, right.right)

    if not root:
        return None
    dfs(root.left, root.right)
    return root


def run_tests():
    tests = [ ([1,2,3,4,5,6,7], [1,None,2,3,None,4,5,6,7,None]),
              ([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15], [1,None,2,3,None,4,5,6,7,None,8,9,10,11,12,13,14,15,None]),
              ([1], [1, None]),
              ([], []),
    ]
    for test in tests:
        root, ans = test[0], test[1]
        print(f"\nPerfect BT")
        if root:
            tree=build_tree_level_order_TreeNextNodeNull(root)
            tree.display()
        else:
            tree = None
        print(f"root = {root}")
        for method in ['bfs1', 'dfs2', 'dfs']:
            if method == 'bfs1':
                out_tree = connect_bfs1(dcp(tree))
            elif method == 'bfs2':
                out_tree = connect_bfs2(dcp(tree))
            elif method == 'dfs':
                out_tree = connect_dfs(dcp(tree))
            connected_bt = levelOrderTraversal_TreeNextNode(out_tree)
            print(f"Method {method}: connect_bt = {connected_bt}")
            passed = (ans == connected_bt)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()