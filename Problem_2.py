'''
99 Recover Binary Search Tree
https://leetcode.com/problems/recover-binary-search-tree/description/

Solution:
1. Inorder traversal + sort:
Capture inorder traversal in a list. The inorder traversal of a BST should ideally generate a sorted array. Since, two nodes in the BST are in the wrong place in the array, sort the array. Now do an inorder traversal of the BST again and replace the node values with the values in the sorted array.
https://www.youtube.com/watch?v=wNGPqQNiHt8
Time: O(N + N log N) = O(N log N), Space: O(N)

2. Inorder traversal w/o sort:
Capture inorder traversal in a list. The inorder traversal of a BST should ideally generate a sorted array. Since, two nodes in the BST are in the wrong place, the order of the elements in the list should be out of place at two places. Traverse the list and find the two values in the list that are out of place. Find the two misplaced nodes in the BST using these two values and swap the values in the BST.
https://youtu.be/wNGPqQNiHt8?t=365
Time: O(2N) = O(N), Space: O(N)

3. Inorder traversal with two variables
Perform an inorder traversal on the BST, capturing the misplaced node using two variables (prev and root). After traversal, we simply swap their values to restore the BST.
https://youtu.be/wNGPqQNiHt8?t=849
Time: O(N), Space: O(H)

4. Iterative Inorder traversal with two variables
Similar to #3 but with iterative inorder traversal instead of recursive
https://youtu.be/wNGPqQNiHt8?t=2415
Time: O(N), Space: O(1)
'''
from typing import Optional
from binary_tree import *

def recoverTree_recur(root: Optional[TreeNode]) -> None:
    ''' Solution #3
        Time: O(N), Space: O(H)
    '''
    def inorder(root):
        nonlocal prev, first, second, count
        if not root or count == 0:
            return
        inorder(root.left)
        if not prev:
            prev = root
        if prev.val > root.val:
            count -= 1
            if not first:
                first = prev
            second = root
        prev = root
        inorder(root.right)
    if not root:
        return
    prev = first = second = None
    count = 2
    inorder(root)
    # swap the two incorrect values
    first.val, second.val = second.val, first.val

def recoverTree_iter(root):
    ''' Solution #4
        Time: O(N), Space: O(1)
    '''
    if not root:
        return
    prev = first = second = None
    stack = []
    count = 2
    curr, prev = root, None
    while (stack or curr) and count != 0:
        while curr:
            stack.append(curr)
            curr = curr.left
        curr = stack.pop()
        if not prev:
            prev = curr
        if prev.val > curr.val:
            count -= 1
            if not first:
                first = prev
            second = curr
        prev = curr
        curr = curr.right
    # swap the two incorrect values
    first.val, second.val = second.val, first.val

def run_recoverTree():
    tests = [ ([50,40,60,30,70,55,45,25,35,42,48,52,58,None,75], [50,40,60,30,45,55,70,25,35,42,48,52,58,75]),
              ([50,40,60,30,48,55,70,25,35,42,45,52,58,None,75],[50,40,60,30,45,55,70,25,35,42,48,52,58,75]),
              ([3,1,4,None,None,2], [2,1,4,3]),
              ([1,3,None,None,2], [3,1,2]),
    ]
    for test in tests:
        root, ans = test[0], test[1]
        for method in ['recur', 'iter']:
            tree=build_tree_level_order(root)
            print(f"\nBroken BST")
            tree.display()
            print(f"root = {root}")
            if method == "recur":
                recoverTree_recur(tree)
                print(f"\nFixed BST (using recursion)")
            elif method == "iter":
                recoverTree_iter(tree)
                print(f"Fixed BST (using iterative)")
            fixed_bst = levelOrderTraversal(tree)
            tree.display()
            print(f"root = {fixed_bst}")
            success = (ans == fixed_bst)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_recoverTree()