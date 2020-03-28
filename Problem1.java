// Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
//Level order traversal suing queue
// Time - O(n)
// Space - O(n)
class Solution {
    public Node connect(Node root) {
       if(root == null)
           return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            Node curr = null;
            for(int i = 0; i < size; i++){
                curr = q.poll();
                if(prev != null) 
                    prev.next = curr;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                prev = curr;
            }
            curr.next = null;
            
        }
        
        return root;
    }
}

//Level order traversal iterative without using an extra DS
// Time - O(n)
// Space - O(1)
class Solution {
    public Node connect(Node root) {
       if(root == null)
           return null;
         
        
        Node firstLevelNode = root;
        while(firstLevelNode.left != null){
            //Perfect BT so dnt have to do null check for right child
            Node curr = firstLevelNode;
            while(curr != null){
               if(curr.left != null){
                    curr.left.next = curr.right;
                    if(curr.next != null){
                        curr.right.next = curr.next.left;
                    }
                } 
                curr = curr.next;
            }
            
           firstLevelNode = firstLevelNode.left;
        }
        return root;
    }
}

//Level order traversal recursive without using an extra DS
// Time - O(n)
// Space - O(Height of the tree)
class Solution {
    public Node connect(Node root) {
        if(root == null)
           return null;
        //Perfect BT so dnt have to do null check for right child
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}