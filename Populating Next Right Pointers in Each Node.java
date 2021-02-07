/*
# bfs
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return root
        
        
        queue = collections.deque()
        queue.append(root)
        
        while len(queue) > 0:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                if i != size -1:
                    cur.next = queue[0]
                
                if cur.left is not None:
                    queue.append(cur.left)
                    queue.append(cur.right)
        return root

# dfs 
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:                                
            return root 
        
        self.dfs(root.left, root.right)
            
        return root
    
    def dfs(self, left, right):
        # base
        if left is None:                     we dont check right is None because it is perfect tree i.e if left exists then right will also
            return
        
        # logic
        left.next = right
        
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)

# O(1) space
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return root
        
        level = root
        
        while level.left is not None:
            cur = level
            
            while cur is not None:
                cur.left.next = cur.right
                if cur.next is not None:
                    cur.right.next = cur.next.left
                cur = cur.next
            level = level.left
            
        return root

#  bfs        
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            
            for (int i=0; i<size; i++){
                Node cur = q.poll();
                
                if (i != size-1){
                    cur.next = q.peek();
                }
                if (cur.left != null){
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
        }
        return root;
    }
}

// dfs time - O(n) space - O(h)
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        
        dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right){
        // base
        if (left == null)
            return;
        
        //  Logic
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
        
    }
}

*/
// Time - O(n)
// Space - O(1)
// Logic - Maintained a level variable which travelled the tree and another cur variable just attached pointers between its left and right child

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        
        Node level = root;
        
        while (level.left != null){
            Node cur = level;
            while (cur != null){
                cur.left.next = cur.right;                  // here we dont check whether right child exists or not because it is perfect binary tree
                if (cur.next !=null){                   
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }
}