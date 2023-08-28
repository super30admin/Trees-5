#Time complexity is O(n)
#Space complexity is O(1)
#No issues faced while coding
#COde ran successfully on leetcode
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        #Base condition
        if(root==None):
            return None
        #Initially we ware taking level as root nde
        self.level=root
        #Until the below condition fails, we will be iterating through the tree
        while(self.level.left!=None):
            #WE will be inititalizing the curr value
            curr=self.level
            #Until we have curr value, we will iterate through the level nodes
            while(curr!=None):
                #We will be assigining next pointers for all the nodes in that level
                curr.left.next=curr.right
                if(curr.next!=None):
                    curr.right.next=curr.next.left
                curr=curr.next
            #We will be moving to the next level
            self.level=self.level.left
        #Finaly we are returning the root value
        return root 
