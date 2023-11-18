# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# implemented both solutions- bfs and optiomized bfs. in optimized bfs we dont need to keep trakc of each level in a queue instead we add its left childs link to rights child and goes on
from Queue import Queue
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        # bfs - O(n), O(n)
        # if not root:
        #     return None
        # q=Queue()
        # q.put(root)
        # while not q.empty():
        #     size=q.qsize()
        #     for i in range(size):
        #         curr=q.get()
        #         if(i != size-1):
        #             curr.next=q.queue[0]
        #         if(curr.left is not None):
        #             q.put(curr.left)
        #             q.put(curr.right)
        # return root

        # optimized bfs O(n), O(1)
        if not root:
            return None
        level=root
        while(level.left is not None):
            curr=level
            while(curr is not None):
                curr.left.next=curr.right
                if(curr.next is not None):
                    curr.right.next=curr.next.left
                curr=curr.next
            level=level.left
        return root