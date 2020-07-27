# Time Complexity : O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self, x):
        self.val = x 
        self.left = None 
        self.right = None 
        self.next = None 
        
class Solution:
    def connect(self, root):
        if not root or root is None:
            return root 
        node = root
        head = root 
        while root:
            while node:
                if node.right:
                    node.left.next = node.right 
                
                if node.next and node.right:
                    node.right.next = node.next.left 
                node = node.next 
            root = root.left 
            node = root
        return head 

if __name__ == "__main__":
    s = Solution()
    n = Node(1)
    n.left = Node(2)
    n.right = Node(3)
    n.left.left = Node(4)
    n.left.right = Node(5)
    n.right.left = Node(6)
    n.right.right = Node(7)
    res = s.connect(n)
    st = []
    while res :
        node = res
        
        while node:
            st.append(node.val)
            node = node.next 
        if node is None:
            st.append('#')
        res = res.left 
    print(st)
            