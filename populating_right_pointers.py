# Time Complexity :
# O(N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We do a BFS level order traversal of the tree. At each level, we make the connection between each of the nodes until the last node. We repeat this at all levels

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None :
            return
        self.queue = collections.deque()
        count = 0

        self.queue.append(root)
        while len(self.queue) != 0 :
            size = len(self.queue)
            for i in range(0,size):
                curr = self.queue.popleft()
                if i != size-1 :
                    curr.next = self.queue[0]
                if curr.left != None :
                    self.queue.append(curr.left)
                    self.queue.append(curr.right)
        return root
