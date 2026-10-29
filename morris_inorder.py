'''
94 Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/description/

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
1_
  \\
  2
 /
3
Input: root = [1,null,2,3]
Output: [1,3,2]


Example 2:
  ___1
 /    \\
 2_   3_
/  \\    \\
4  5    8
  / \\  /
  6 7  9
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]
Explanation:

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]


Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?

Solution:
1. DFS Recursive
Time: O(N), Space: O(H)

2. DFS Iterative
Time: O(N), Space: O(H)

3. Morris
https://youtu.be/9Se8kwMA8kQ?t=3138 (JS)
https://youtu.be/9Se8kwMA8kQ?t=5110 (JS Time Complexity)
https://www.youtube.com/watch?v=80Zug6D1_r4 (Striver)
https://youtu.be/80Zug6D1_r4?t=1159 (One line change in Morris to change from inorder to preorder traversal)
Time: O(NH) worst case but O(N) amortized, Space: O(1)
Why O(NH) is worst case? Because at every node (total N nodes), we traverse down to the right most node which is height of the tree (H).
'''
from binary_tree import *

def inorder_recursive(root):
    ''' Time: O(N), Space: O(H) '''
    def inorder(root):
        if not root:
            return None
        inorder(root.left)
        array.append(root.val)
        inorder(root.right)

    if not root:
        return []
    array = []
    inorder(root)
    return array

def inorder_iterative(root):
    ''' Time: O(N), Space: O(H) '''
    if not root:
        return []
    array = []
    stack = []
    #stack.append(root)
    curr = root
    while (stack or curr):
        while curr:
            stack.append(curr)
            curr = curr.left
        curr = stack.pop()
        array.append(curr.val)
        curr = curr.right
    return array

def inorder_morris(root):
    ''' Time: Amortized O(N), Space: O(1) '''
    if not root:
        return None
    arr = []
    curr = root
    while curr:
        if curr.left:
            # 1. Find the inorder predecessor (rightmost node of left subtree)
            pred = curr.left
            while pred.right and pred.right != curr:
                pred = pred.right

            # 2. If the bridge doesn't exist, we have reached the right most
            # node. Create the bridge between right most node and current
            # and move current to its left
            if pred.right is None:
                pred.right = curr
                curr = curr.left
            else:
                # 3. If bridge exists, we've visited the left side already.
                # Cut the bridge, record current node, and move right.
                pred.right = None
                arr.append(curr.val) # print right node of current subtree
                curr = curr.right
        else:
            # 4. No left child, so read current and move right
            arr.append(curr.val) # print root node of current subtree
            curr = curr.right
    return arr


def run_inorder():
    tests = [([1,None,2,3],[1,3,2]),
             ([1,2,3,4,5,None,8,None,None,6,7,9],[4,2,6,5,7,1,3,9,8]),
             ([1,2,3,4,5,None,None,None,None,None,6], [4,2,5,6,1,3]),
             ([], []), ([1],[1])
    ]
    tests = [([1,2,3,4,5,None,None,None,7,None,6,8,9],[4,8,7,9,2,5,6,1,3]),]
    for test in tests:
        root, ans = test[0], test[1]
        if root:
            tree=build_tree_level_order(root)
            tree.display()
        else:
            tree = []
        print(f"\nroot = {root}")
        for method in ['recur', 'iter', 'morris']:
            if method == "recur":
                array = inorder_recursive(tree)
            elif method == "iter":
                array = inorder_iterative(tree)
            elif method == "morris":
                array = inorder_morris(tree)
            print(f"Method {method}:  inorder traversal = {array}")
            passed = (ans == array)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_inorder()