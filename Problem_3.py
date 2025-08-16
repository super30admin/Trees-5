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
https://www.youtube.com/watch?v=PUfADhkq1LI (Morris inorder traversal)
https://youtu.be/80Zug6D1_r4?t=1159 (One line change in Morris to change from inorder to preorder traversal)
Time: Amortized O(N), Space: O(1)
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
    def right_most_node_left_subtree(left_subtree, parent):
        curr = left_subtree
        while curr:
            if curr.right: # if right node exists
                # if right child to root connection already exists, return
                # right child. Else go further right
                if curr.right != parent:
                    curr = curr.right # go right
                else:
                    break # return right child
            elif curr.left: # if right node doesn't exist but left node exists
                curr = curr.left # go left
            else: #not curr.left and not curr.right
                break
        return curr

    if not root:
        return []
    array=[]
    curr, predecessor = root, root
    while curr:
        if not curr.left: # if curr.left doesn't exist, go right
            array.append(curr.val)
            curr = curr.right
        else: # curr.left exists
            # get the inorder predecessor (IP) node
            predecessor = right_most_node_left_subtree(curr.left, curr)

            # if thread between IP and parent (curr):
            # a) doesn't exist, then create it
            # b) already exists, then delete it
            if predecessor.right is None:
                predecessor.right = curr # create thread
                curr = curr.left # keep going left (per inorder traversal)
            else:
                predecessor.right = None # delete thread
                array.append(curr.val) # add parent
                curr = curr.right # move right of parent
    return array

def run_inorder():
    tests = [([1,None,2,3],[1,3,2]),
             ([1,2,3,4,5,None,8,None,None,6,7,9],[4,2,6,5,7,1,3,9,8]),
             ([1,2,3,4,5,None,None,None,None,None,6], [4,2,5,6,1,3]),
             ([], []), ([1],[1])
    ]
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
            success = (ans == array)
            print(f"Method {method}:  inorder traversal = {array}")
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_inorder()