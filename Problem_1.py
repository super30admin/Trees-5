"""
Problem : 1

Time Complexity : O(n)

Space Complexity : 
Approach 1 & 2 - O(n)
Approach 3 - O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Populating Next Right Pointers in Each Node

# Approach - 1

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return None
        q=collections.deque()
        q.append(root)
        root.next=None
        while q:
            level=[]
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                level.append(curr)
                if curr.left or curr.right:
                    q.append(curr.left)
                    q.append(curr.right)
            self.connectLevel(level)

        return root

    def connectLevel(self,level):
        for i in range(len(level)):
            if i==len(level)-1:
                node=level[i]
                node.next=None
            else:
                node=level[i]
                nextNode=level[i+1]
                node.next=nextNode

# Approach - 2

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return None
        q=collections.deque()
        q.append(root)

        while q:

            size=len(q)
            for i in range(size):
                curr=q.popleft()
                if i!=size-1:
                    curr.next=q[0]
                if curr.left or curr.right:
                    q.append(curr.left)
                    q.append(curr.right)
        return root


# Approach - 3
# Two Pointer

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return None
        level=root

        while level.left:
            curr=level
            while curr:
                curr.left.next=curr.right
                if curr.next:
                    curr.right.next=curr.next.left
                curr=curr.next
            level=level.left
        return root