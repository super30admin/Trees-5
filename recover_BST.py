# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class solution:
    def __init__(self):
        '''
        Initializing the first, second and previous pointers that we will be using to flag the breach 
        '''
        self.first = None
        self.second = None
        self.prev = None
    def recover_recursive(self, root):
        self.helper(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    
    def helper(self, root):
        '''
        In the recursive approach we will do an inorder traaversal such that when we compute root we will see 
        if the current node is less than the prev . if yes then we check if our first pointer is None. 
        if Yes then it is our first breach else it will be second breach. In the first breach we weill set the second as prev and first as root
        and in second breach we will only update the first. 

        Then we will update the previous to root and recurse in root.right

        in the end , once the traversal is done we will swap the values between first and second.
        '''
        ## base

        if root == None:
            return 
        ##logic

        self.helper(root.left)

        if self.prev != None and root.val <= self.prev.val:
            if self.first == None:
                self.second = self.prev
                self.first = root 
            else:
                self.first = root 
        self.prev = root
        self.helper(root.right)
    

    def recover_iterative(self, root):
        '''
        In the iterative approach. we will use a stack. In the stack we will append all the left nodes unbtil we reach None.

        then we will pop the lement and comare with prev. If it is less than previous we again check if first breach has happened or not. 

        if yes then update first to root and second to prev. Else only update first to root

        then update prev to root. 

        then make root = root.right

        once we have processed everything swap first and second. 
        
        '''
        stack = []

        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()

            if self.prev and root.val <= self.prev.val:
                if self.first == None:
                    self.first = root
                    self.second = self.prev
                else:
                    self.first = root
            
            self.prev = root

            root = root.right
        
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp


