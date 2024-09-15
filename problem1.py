#Populating Next Right Pointers in Each Node
# // Time Complexity :  O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root==None: return root
        pre=root
        curr=None
        while(pre.left):                #keep going till there is no more left tree left, as its a perfect binary tree
            curr=pre
            while(curr):                #for all the nodes in the current level
                curr.left.next = curr.right             #set their left to right
                if(curr.next):
                    curr.right.next = curr.next.left            #if theres a next node, then set the current right to next's left
                curr=curr.next
            pre=pre.left

        return root