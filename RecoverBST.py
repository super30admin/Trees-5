'''
Solution:
1.  In both recursion and iteration approaches, maintain a pointer named previous and make an
    inorder traversal to find out which two nodes are in the wrong place.
2.  First node which is at wrong place is where current node is less than previous node and so 
    the wrong location is of previous node here.
3.  Second node which is at wrong place has the same condition to check but the wrong location
    is of the current node this time. Swap these two nodes' values and return the main root.

Time Complexity:    O(n) in both cases, where n is the number of nodes in the tree
Space Complexity:   O(h) in both cases, where h is the height of the tree

--- Passed all testcases for both the solutions on Leetcode.
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Wrapper:

    #   A wrapper class just to avoid using global variables.
    def __init__(self):
        self.prev = TreeNode(float('-inf'))
        self.first = None
        self.second = None

class RecoverBSTIteration:
    
    def __swap(self, node1: TreeNode, node2: TreeNode) -> None:

        #   function to swap two nodes
        tempVal = node1.val
        node1.val = node2.val
        node2.val = tempVal
    
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        #   edge case check
        if (root == None):
            return
        
        #   create a wrapper class object which initializes prev, first and second nodes
        wrapObj = Wrapper()
        
        #   initialize stack
        stack = []
        currNode = root
        
        #   fill the stack till it reaches first minimum node
        while (currNode != None):
            stack.append(currNode)
            currNode = currNode.left
        
        #   iterate until the stack is empty in a BST Iterator fashion    
        while (len(stack) > 0):
            
            #   pop the next min node
            nextMinNode = stack.pop()
            
            #   condition fot first misplaced node
            if (wrapObj.first == None and wrapObj.prev.val > nextMinNode.val):
                wrapObj.first = wrapObj.prev

            #   condition for second misplaced node
            if (wrapObj.first != None and wrapObj.prev.val > nextMinNode.val):
                wrapObj.second = nextMinNode
            
            #   update previous node
            wrapObj.prev = nextMinNode
            
            #   push until you find next minimum node
            if (nextMinNode.right != None):
                currNode = nextMinNode.right
                while (currNode != None):
                    stack.append(currNode)
                    currNode = currNode.left
        
        #   swap first and second nodes' values
        self.__swap(wrapObj.first, wrapObj.second)


class RecoverBSTRecursion:
    
    def __swap(self, node1: TreeNode, node2: TreeNode) -> None:
        tempVal = node1.val
        node1.val = node2.val
        node2.val = tempVal
        
    def __helper(self, root: TreeNode, wrapObj: Wrapper) -> None:
        
        #   base case
        if (root == None):
            return
        
        #   left subtree recursion
        self.__helper(root.left, wrapObj)
        
        # condition for first misplaced node
        if (wrapObj.first == None and wrapObj.prev.val > root.val):
            wrapObj.first = wrapObj.prev

        #   condition for second misplaced node
        if (wrapObj.first != None and wrapObj.prev.val > root.val):
            wrapObj.second = root

        #   update previous node to current
        wrapObj.prev = root
        
        #   right subtree recursion
        self.__helper(root.right, wrapObj)
    
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #   edge case check
        if (root == None):
            return
        
        #   create a wrapper class object which initializes prev, first and second nodes
        wrapObj = Wrapper()
        
        #   call the helper function which updates wrapper class object's attributes
        self.__helper(root, wrapObj)
        
        #   return root
        self.__swap(wrapObj.first, wrapObj.second)