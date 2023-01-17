

# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class solution:
    def populate_right_iterative(self, root):
        '''
        In the iterative approach we perform all actions in a level and then move to the next level. we initiate a current pointer at root
        and the nxt pointer at the root.left to maintain the start of next level. we see if curr and next esist. and connect the left and right child of a root. if curr.next exists
        then we connect curr.right and curr.next.left. and move curr to curr.next and more nexts exist ina level it will keep going. once we hit None for curr then we move it to next and update next to curr.left
        '''
        curr = root
        nxt = curr.left

        while curr and nxt:

            
            curr.left.next = curr.right
            
            if curr.next:
                curr.right.next = curr.next.left
                


            curr = curr.next

            if not curr:
                curr = nxt
                nxt = curr.left
        
        return root

    
    def populate_right_recusrsive(self, root):
        '''
        The recursive approach is lightly different from the iterative approach. we first go deep and connect the left and right children and when we recurse back we connect the curr and next pointers .

        for each root that we go to we check if it has a left child. if yes then we connect the left and right child of the root. now if the curr root.right and root.next exist then we connect the right of root to left of root.next . 

        i.e we come a step back and connect them.  
        '''
        ## base 
        if root == None:
            return None


        ## logic

        if root.left:
            root.left.next = root.right
        
        if root.right and root.next:
            root.right.next = root.next.right
        self.populate_right_recusrsive(root.left)
        self.populate_right_recusrsive(root.right)

        return root