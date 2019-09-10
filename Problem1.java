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
