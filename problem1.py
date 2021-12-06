#time ,space O(n)
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        #Dfs
        if not root:
            return None
        
        if root.left:
            root.left.next = root.right
            if root.next and root.right:
                root.right.next = root.next.left
        
        self.connect(root.left)
        self.connect(root.right)
        
        return root
        
        
        #level order
        if not root:
            return None
        
        lev=root
        
        while lev.left:
            cur=lev
            
            while cur:
                cur.left.next=cur.right
                if cur.next:
                    cur.right.next=cur.next.left
                cur=cur.next
            lev=lev.left
            
        return root

 
