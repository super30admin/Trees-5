//Time : O(n)
// Space: O(n)

//Approach
//1 . Do a bfs traversal . Add elements in each level at once.In each level while traversing from left to right point current node to next node in same level.
// 2. If current node is at extreme right then point it to null
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null)    return null;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                Node temp = queue.poll();
                size--;
                if(size == 0)   temp.next = null;
                else temp.next = queue.peek();
                if(temp.left!=null && temp.right!=null) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                } 
            }
        }
        return root;
    }
}
// Constant Time Approach
//Time : O(n)
// Space: O(1)

//Approach
//1 . Have two pointers , start and current.Initially current is equal to start.
//2 . Now make current's left node next pointer as current's right node. Now if current has a next pointer then change current to current's next pointer.Repeat step 2 till current's next node is null.
// 3. Now we need to move to next level . So change start to start's left node and change current to start.Repeat step 2 and 3 till all levels are done.
class Solution {
    public Node connect(Node root) {
        Node start = root;
        Node current = root;
        while(start!=null){
            current = start;
            while(current!=null){
                if(current.left!=null ) current.left.next = current.right;
                if(current.right!=null && current.next!=null) current.right.next = current.next.left;
                current = current.next;
            }
            start = start.left;
        }
        return root;
    }
}
