#TC: O(n)
#SC: O(h)

class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class PopulateNextRightRecursion:
    def connect(self, root: 'Node') -> 'Node':
        
        if (root == None):
            return root
        
        if (root.left != None):
            root.left.next = root.right
            if (root.next != None):
                root.right.next = root.next.left
        
        self.connect(root.left)
        self.connect(root.right)
        
        return root

class PopulateNextRightIteration:
    def connect(self, root: 'Node') -> 'Node':
        
        if (root == None):
            return root
        
        firstNodeOfLevel = root
        
        while (firstNodeOfLevel != None):
            
            currentNode = firstNodeOfLevel
            while (currentNode != None):

                if (currentNode.left != None):
                    currentNode.left.next = currentNode.right
                    if (currentNode.next != None):
                        currentNode.right.next = currentNode.next.left

                currentNode = currentNode.next
            
            firstNodeOfLevel = firstNodeOfLevel.left
           
        return root