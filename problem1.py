#Time  Complexity O(N)
#Space Complexity O(N)

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        q = []
        q.append(root)
        level = []
        while q:
            level = []
            for i in range(len(q)):
                curr = q.pop(0)
                level.append(curr)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            i = 0 
            while i+1 < len(level):
                level[i].next = level[i+1]
                i += 1
            level[i].next = None
        return root
