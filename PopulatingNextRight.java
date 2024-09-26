//BFS Approach
class Solution {

    // Time Complexity : 0(n) where n is the no. of nodes in tree
// Space Complexity :0(n) where n is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> q = new LinkedList<>(); //doing a bfs level wise to connect the next at each level
        q.add(root);    //adding the root to the queue
        while(!q.isEmpty()){
            int size = q.size();    //getting the size so that we can take care of the next pointer at each leve
            Node curr = q.poll();   //polling before the loop begins so that we don't have to take care of the attaching the root notes
            if(curr.left != null){  //adding the left and right child of root nodes to the queue
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
            for(int i = 1; i < size; i++){  //running the loop at each level to connect all of the children at that level
                Node temp = q.poll();   //removing the node from the queue, at first the right node comes out, and we store it in temp. current holds left node, so we attach current's next to temp
                curr.next = temp;
                curr = temp;    //then we make the right node as our current and add its children to the queue and so on
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}

//Two pointer approach


class Solution {

    // Time Complexity : 0(n) where n is the no. of nodes in tree
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node level = root;  //declaring a node level to traverse through every level and make the connection
        while(level.left != null){  //since it is a perfect BST, if next level's left is null, there wont be another level
            Node curr = level;  //assigning current to the level
            while(curr != null){    //till current is not equal as it will get null at each level when current points to right node's next
                curr.left.next = curr.right;
                if(curr.next != null){  //only if we are not facing at the right most node, whose next will be null
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;   //moving current to next
            }
            level = level.left; //increasing level after all the connections at each level
        }
        return root;
    }
}

//dfs approach

class Solution {

    // Time Complexity : 0(n) where n is the no. of nodes in tree
// Space Complexity :0(h) where h is the height of the tree or the recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        dfs(root.left, root.right);
        return root;
    }
    public void dfs(Node left, Node right){
        if(left == null){
            return;
        }
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}

