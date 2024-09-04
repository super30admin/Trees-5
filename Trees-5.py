# Trees-5

## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
# from queue import Queue # for 1. BFS using Queue
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
# 3. DFS        
        if root ==None:
            return root
        self.dfs(root.left, root.right)
        return root
    def dfs(self,left: 'Optional[Node]', right: 'Optional[Node]')-> None:
        if left == None:
            return
        left.next = right
        self.dfs(left.left,left.right)
        self.dfs(left.right,right.left)
        self.dfs(right.left,right.right)

#2. BFS
        # if root == None:
        #     return root
        # left = root
        # while left.left != None:
        #     curr = left
        #     while curr!= None:
        #         curr.left.next = curr.right
        #         if curr.next != None:
        #             curr.right.next = curr.next.left
        #         curr = curr.next
        #     left = left.left
        # return root

# 1. BFS
        # if root == None:
        #     return root
        # q = Queue()
        # q.put(root)
        # while q.qsize() >0:
        #     size = q.qsize()
        #     for i in range(size):
        #         curr = q.get()
        #         if i < size-1:
        #             curr.next = q.queue[0]
        #         if curr.left!= None:
        #             q.put(curr.left)
        #             q.put(curr.right)
        # return root

#1. BFS - TC = O(n); SC = O(n)
#2. BFS - TC = O(n); SC = O(1) -- most optimized solution
#3. DFS - TC = O(n); SC = O(h)
        

## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return
        self.prev = None
        self.first = None
        self.second = None
        self.count = 0
        self.dfs(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
    
    def dfs(self, root: Optional[TreeNode]) -> None:
        #base
        if root == None or self.count >= 2: 
            return 
        #logic
        self.dfs(root.left)
        if self.prev != None and self.prev.val > root.val:
            if self.first == None:
                self.first = self.prev
            self.second = root
            self.count =  self.count + 1
        self.prev = root
        self.dfs(root.right)

#TC = O(n); SC:O(h)

## Problem3 Morris Inorder Traversal (https://leetcode.com/problems/binary-tree-inorder-traversal/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # Initialize the output list to store the inorder traversal
        result = []
      
        # Continue traversing until there are no more nodes to process
        while root:
            # If there is no left child, add the current node's value to the result
            # and move to the right child
            if root.left is None:
                result.append(root.val)
                root = root.right
            else:
                # Find the rightmost node in the left subtree or the left child itself
                # if it does not have a right child. This node will be our "predecessor"
                predecessor = root.left
                while predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right
              
                # If the predecessor's right child is not set to the current node,
                # set it to the current node and move to the left child of the current node
                if predecessor.right is None:
                    predecessor.right = root
                    root = root.left
                else:
                    # If the predecessor's right child is set to the current node,
                    # it means we have processed the left subtree, so add the current
                    # node's value to the result and sever the temporary link to restore
                    # the tree structure. Then, move to the right child.
                    result.append(root.val)
                    predecessor.right = None
                    root = root.right
      
        # Return the result of the inorder traversal
        return result
# TC = O(n), SC = O(1)