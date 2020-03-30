'''
Solution:
1.  In this question, instead of normal BFS which uses a queue, we can use the next pointers
    and update the node's next pointers at next level towards their nodes at their right using 
    a pointer pointing at current level's first node.
2.  If current node's left exists => point its next to node's right
    If current node's next exists => point its right to next node's left.
3.  The only difference between recursion and iteration is that recursion requires extra
    logN recursive stack space.

Time Complexity:    O(n) for both the cases.
Space Complexity:   O(h) for recursive solution and O(1) for iterative approach.

--- Passed all testcases successfully for both solutions on leetcode.xs
'''


# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class PopulateNextRightRecursion:
    def connect(self, root: 'Node') -> 'Node':
        
        #   base case
        if (root == None):
            return root
        
        #   if root's left exits => point its left next to its right
        if (root.left != None):
            root.left.next = root.right
            #   now if root's next exits => point its right's next to its next's left
            if (root.next != None):
                root.right.next = root.next.left
        
        #   recursion on left and right subtrees       
        self.connect(root.left)
        self.connect(root.right)
        
        #   return root
        return root

class PopulateNextRightIteration:
    def connect(self, root: 'Node') -> 'Node':
        
        #   edge case check
        if (root == None):
            return root
        
        #   initialize the first node of each level (now the main root)
        firstNodeOfLevel = root
        
        #   iterate until the level of the tree exists
        while (firstNodeOfLevel != None):
            
            #   iterate over the current level and assign next pointers of nodes at next level
            currentNode = firstNodeOfLevel
            while (currentNode != None):

                #   if current node's left exits => point its left next to its right
                if (currentNode.left != None):
                    currentNode.left.next = currentNode.right
                    #   now if current node's next exits => point its right's next to its next's left
                    if (currentNode.next != None):
                        currentNode.right.next = currentNode.next.left
                #   update current node to its next
                currentNode = currentNode.next
            
            #   update each level's first node once the level is complete  
            firstNodeOfLevel = firstNodeOfLevel.left
         
        #   return the root   
        return root