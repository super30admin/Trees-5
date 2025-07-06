# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right 

'''
Time Complexity: O(n) because we are only traversing the tree for identifying the breached nodes. 
Space Complexity: O(1)+O(h) where h is the height of the tree, which is the space used by the recursion stack and O(1) is for the variables used to store the nodes.
'''
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # First and second node is for denoting the breach of BST
        self.firstNode: Optional[TreeNode] = None
        self.secondNode: Optional[TreeNode] = None
        # Previous node is to track during traversal
        self.previousNode: Optional[TreeNode] = None

        def inorder(self, node: Optional[TreeNode]):
            if not node:
                return

            inorder(self, node.left)

            if self.previousNode is not None and self.previousNode.val >= node.val:
                if self.firstNode is None:
                    self.firstNode = self.previousNode
                self.secondNode = node

            self.previousNode = node

            inorder(self, node.right)

        inorder(self, root)

        print("First and second values are ", self.firstNode.val, self.secondNode.val)

        temp = self.firstNode.val
        self.firstNode.val = self.secondNode.val
        self.secondNode.val = temp



# ------------------    Iterative Approach       ----------------------  

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right 
'''
Time Complexity: O(n) because we are only traversing the tree for identifying the breached nodes.
Space Complexity: O(h) where h is the height of the tree, which is the space used by the stack.
'''
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # First and second node is for denoting the breach of BST
        self.firstNode: Optional[TreeNode] = None
        self.secondNode: Optional[TreeNode] = None
        # Previous node is to track during traversal
        self.previousNode: Optional[TreeNode] = None

        def iterativeInOrder(node: Optional[TreeNode]):
            stack = []
            while stack or node is not None: 
                while node:
                    stack.append(node)
                    node = node.left
                node = stack.pop()
                if self.previousNode and self.previousNode.val >= node.val:
                    if self.firstNode is None:
                        self.firstNode = self.previousNode
                    self.secondNode = node 
                self.previousNode = node 
                node = node.right
                # where are we assigning the previous node? 

        iterativeInOrder(root)

        print("First and second values are ", self.firstNode.val, self.secondNode.val)

        temp = self.firstNode.val
        self.firstNode.val = self.secondNode.val
        self.secondNode.val = temp
