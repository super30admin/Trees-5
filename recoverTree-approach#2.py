'''
Did it run on leetcode: Yes
Did you face any problem: Lot of problems

Time complexity: 0(n)
Space Complexity: 0(h)

Algorithm:
- Traverse the whole tree in an inorder fashion and keep track of prev value
- When you find current val less than the prev value, this is where our problem occcurs
- Declare two pointers x,y pointing to curr node and prev node
- come out of the while loop and exchange node values of x and y.

'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        temp = root
        prev,x,y = None,None,None
        
        stack = []
        while stack or temp:
            while temp:
                stack.append(temp)
                temp = temp.left
            temp = stack.pop()
            if prev!=None and prev.val>temp.val:
                y=temp
                if not x:
                    x=prev
                else:
                    break
            prev = temp
            temp = temp.right
        
        tmp = x.val
        x.val = y.val
        y.val = tmp
        return