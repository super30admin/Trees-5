
//Extra Space
class Solution {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            Node prev = q.poll();
            
            if (prev.left != null)q.add(prev.left);
            if (prev.right != null)q.add(prev.right);
            
            for (int i = 1; i < size; i++){
                Node curr = q.poll();
                
            if (curr.left != null)q.add(curr.left);
            if (curr.right != null)q.add(curr.right);
            
            prev.next = curr;
            prev = curr;    
                
            }
            
        }
        
        return root;
    }
}

//No Space

class Solution {
    public Node connect(Node root) {
        
        if (root == null)return null;
        
        Node temp = root;
        
        while(temp != null){
            Node curr = temp;
            while (curr != null){
                if (curr.left != null){
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            temp = temp.left;
        }
        return root;
    }
}

//DFS

class Solution {
    public Node connect(Node root) {
        
        if (root == null)return null;
        dfs(root);
        return root;
        
    }
    
    private void dfs(Node root){
        if (root == null)return;
        
        if (root.left != null){
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null){
            root.right.next= root.next.left;
        }
        
        dfs(root.left);
        dfs(root.right);
    }
}