#Time Complexity :O(n) 
#Space Complexity :o(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if(root==None):
            return root

        level=root
        
        while(level.left!=None):
            curr=level
            while(curr!=None):
                curr.left.next=curr.right
                #Check if next Node exist
                if(curr.next!=None):
                    curr.right.next=curr.next.left
                curr=curr.next
            #go to next level
            level=level.left
        return root
        
        
#         queue=collections.deque()
#         queue.append(root)
#         while(queue):
#             size=len(queue)
#             for i in range(size):
#                 curr=queue.popleft()
#                 if(i<size-1):
#                     curr.next=queue[0]
#                 if(curr.left!=None):
#                     queue.append(curr.left)
#                 if(curr.right!=None):
#                     queue.append(curr.right)
                    
#         return root
            
            
    