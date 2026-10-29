'''
99 Recover Binary Search Tree
https://leetcode.com/problems/recover-binary-search-tree/description/

You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Constraints:
The number of nodes in the tree is in the range [2, 1000].
-2^31 <= Node.val <= 2^31 - 1

Example 1:
 _1
/
3
 \
 2
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
_3
/
1
 \
 2

Example 2:
 3_
/  \
1  4
  /
  2
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 2_
/  \
1  4
  /
  3

Solution:
1. Inorder traversal + sort:
Capture inorder traversal in a list. The inorder traversal of a BST should ideally generate a sorted array. Since, two nodes in the BST are in the wrong place in the array, sort the array. Now do an inorder traversal of the BST again and replace the node values with the values in the sorted array.
https://www.youtube.com/watch?v=wNGPqQNiHt8
Time: O(N + N log N) = O(N log N), Space: O(N)

2. Inorder traversal w/o sort:
Capture inorder traversal in a list. The inorder traversal of a BST should ideally generate a sorted array. Since, two nodes in the BST are in the wrong place, the order of the elements in the list should be out of place at two places. Traverse the list and find the two values in the list that are out of place. Find the two misplaced nodes in the BST using these two values and swap the values in the BST.

Note: In the problem, it is given that exactly two nodes of the tree were swapped by mistake. Hence, in the inorder traversal array of such a broken BST,
the max no. of breaches possible is 2.

Examples:
1. Example with 1 breach in inorder array
Broken BST
 3_
/  \
1  4
  /
  2
[1, 3, 2, 4] (broken inorder)
    <-->
    breach

Fixed BST
 2_
/  \
1  4
  /
  3
[1, 2, 3, 4] (fixed inorder)



2. Example with 2 breaches in inorder array
Broken BST

        ______50_______
       /               \\
    __40___         __60_
   /       \\       /     \\
  30_      70     55_      45
 /   \\   /   \\   /   \\    \\
25   35  42   48  52   58     75
[25, 30, 35, 40, 42, 70, 48, 50, 52, 55, 58, 60, 45, 75] (broken inorder)
                 <---->                      <---->
                 breach                      breach


Fixed BST
        ______50_______
       /               \\
    __40___         __60_
   /       \\       /     \\
  30_      45_      55_     70_
 /   \\   /   \\   /   \\     \\
25   35  42   48  52   58      75
[25, 30, 35, 40, 42, 45, 48, 50, 52, 55, 58, 60, 70, 75] (fixed inorder)

Time: O(2N) = O(N), Space: O(N)
https://youtu.be/wNGPqQNiHt8?t=365


3. Inorder traversal with two variables: (this solution is the most tricky)
Perform an inorder traversal on the BST, capturing the misplaced node using two variables (prev and root). After traversal, we simply swap their values to restore the BST.
Time: O(N), Space: O(H)
https://youtu.be/wNGPqQNiHt8?t=849


4. Inorder traversal with two variables and early termination:
Similar to #3. The only difference is that we terminate the traversal as soon as we discover two breaches. We don't need to traverse all the nodes after two breaches. Early termination doesn't change the asymptotic TC though. Why? For example, if there is only 1 breach, we still have to traverse all nodes O(N).
Time: O(N), Space: O(H)
https://youtu.be/wNGPqQNiHt8?t=2047


5. Iterative Inorder traversal with two variables: (most optimal)
Iterative version of #4. Straight forward extension of #4.
Time: O(N), Space: O(1)
https://youtu.be/wNGPqQNiHt8?t=2415

'''
from typing import Optional
from binary_tree import *
from copy import deepcopy as dcp


def recoverTree_2(root: Optional[TreeNode]) -> None:
    ''' Solution #2: Use a list to save in-order traversal
        Time: O(N), Space: O(N + H) = O(N)
    '''
    def inorder(root):
        nonlocal array
        if not root:
            return
        inorder(root.left)
        array.append(root)
        inorder(root.right)

    if not root:
        return
    array = []
    inorder(root) # time = O(N), space = O(H)
    prev = None
    breach = 2 # no more than two violations in inorder traversal
    for curr in array: # time = O(N), space = O(N)
        if prev and curr.val < prev.val:
            if breach == 2:
                first = prev
                second = curr
            elif breach == 1:
                second = curr
            breach -= 1
        prev = curr
    first.val, second.val = second.val, first.val
    return

def recoverTree_3(root: Optional[TreeNode]) -> None:
    ''' Solution #3: Use prev and curr pointers to save the breaches
         Time: O(N), Space: O(H)
    '''
    def inorder(root):
        nonlocal prev, first, second
        if not root:
            return
        inorder(root.left)
        if prev and prev.val > root.val:
            if not first:
                first = prev
                second = root
            else:
                second = root
        prev = root
        inorder(root.right)

    if not root:
        return
    prev = None
    first = second = None
    inorder(root)
    first.val, second.val = second.val, first.val

def recoverTree_4(root: Optional[TreeNode]) -> None:
    ''' Solution #4 = Solution #3 + early termination
         Time: O(N), Space: O(H)
    '''
    def inorder(root):
        nonlocal prev, first, second, breach
        if not root or breach == 2:
            return
        inorder(root.left)
        if prev and prev.val > root.val:
            breach += 1
            if not first:
                first = prev
                second = root
            else:
                second = root
        prev = root
        inorder(root.right)

    if not root:
        return
    prev = None
    first = second = None
    breach = 0
    inorder(root)
    first.val, second.val = second.val, first.val

def recoverTree_5(root):
    ''' Solution #5 = Iterative version of solution 4
        Time: O(N), Space: O(1)
    '''
    if not root:
        return
    prev = first = second = None
    stack = []
    breach = 0
    curr, prev = root, None
    while stack or curr:
        while curr:
            stack.append(curr)
            curr = curr.left
        curr = stack.pop()
        if prev and prev.val > curr.val:
            breach += 1
            if not first:
                first = prev
                second = curr
            else:
                second = curr
        prev = curr
        curr = curr.right
    first.val, second.val = second.val, first.val


def run_tests():
    tests = [ ([50,40,60,30,70,55,45,25,35,42,48,52,58,None,75], [50,40,60,30,45,55,70,25,35,42,48,52,58,75]), # 2 breaches in inorder array
              ([50,40,60,30,48,55,70,25,35,42,45,52,58,None,75],[50,40,60,30,45,55,70,25,35,42,48,52,58,75]), # 1 breach
              ([3,1,4,None,None,2], [2,1,4,3]),
              ([1,3,None,None,2], [3,1,2]),
    ]
    for test in tests:
        root, ans = test[0], test[1]
        t=build_tree_level_order(root)
        print(f"\nBroken BST")
        t.display()
        print(f"root = {root}")
        for method in [2, 3, 4, 5]:
            tree = dcp(t)
            if method == 2:
                recoverTree_2(tree)
            elif method == 3:
                recoverTree_3(tree)
            elif method == 4:
                recoverTree_4(tree)
            elif method == 5:
                recoverTree_5(tree)
            print(f"Method {method}:")
            fixed_bst = levelOrderTraversal(tree)
            tree.display()
            print(f"fixed_bst = {fixed_bst}")
            print(f"expected  = {ans}")
            passed = (ans == fixed_bst)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
        print(f"------\n")
    print(f"\nDONE")

run_tests()