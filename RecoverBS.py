#TC: O(n)
#SC: O(h)

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Wrapper:

    def __init__(self):
        self.prev = TreeNode(float('-inf'))
        self.first = None
        self.second = None

class RecoverBSTIteration:
    
    def __swap(self, node1: TreeNode, node2: TreeNode) -> None:

        tempVal = node1.val
        node1.val = node2.val
        node2.val = tempVal
    
    def recoverTree(self, root: TreeNode) -> None:
        
        if (root == None):
            return
        
        wrapObj = Wrapper()
        
        stack = []
        currNode = root
        
        while (currNode != None):
            stack.append(currNode)
            currNode = currNode.left
         
        while (len(stack) > 0):
            
            nextMinNode = stack.pop()
            
            if (wrapObj.first == None and wrapObj.prev.val > nextMinNode.val):
                wrapObj.first = wrapObj.prev

            if (wrapObj.first != None and wrapObj.prev.val > nextMinNode.val):
                wrapObj.second = nextMinNode
            
            wrapObj.prev = nextMinNode
            
            if (nextMinNode.right != None):
                currNode = nextMinNode.right
                while (currNode != None):
                    stack.append(currNode)
                    currNode = currNode.left
        
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
        
        self.__helper(root.left, wrapObj)
        
        if (wrapObj.first == None and wrapObj.prev.val > root.val):
            wrapObj.first = wrapObj.prev

        if (wrapObj.first != None and wrapObj.prev.val > root.val):
            wrapObj.second = root

        wrapObj.prev = root
        
        self.__helper(root.right, wrapObj)
    
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if (root == None):
            return
        
        wrapObj = Wrapper()
        
        self.__helper(root, wrapObj)
        
        self.__swap(wrapObj.first, wrapObj.second)