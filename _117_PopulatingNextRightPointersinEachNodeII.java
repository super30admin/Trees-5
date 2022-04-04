
// Time Complexity : o(n) where n is number of nodes in tree
// Space Complexity : o(h) whre h is the height of tree
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach
//Approach 1 : Using preorder traversal and calculating and passing the next pointer for teh left and right child
/* Based on my understanding this approach would not work.
As we go down further in recusrion there might be case when next pointer in the nodes in level above are not populated,
since we do not visit all nodes in every level and we continue going down.
Test case to consider for failure : [1,2,3,4,5,null,6,7,null,null,null,null,8]

Let me know if my understanding is incorrect and if there is a way to solve this using recursion.
Also, Let me know if the code below can be tweaked to make it work.
*/

class Solution {
    public Node connect(Node root) {
        preorder(root, null);
        return root;
    }
    public void preorder(Node root, Node next){
        if( root == null) return;
        root.next = next;
        Node nextLeft = null;
        Node nextRight = null;
       // calculating next pointer for the left node to be passed in the next recusrive call
        if(root.left != null){
            Node curr = root;
            while(curr != null){
                if(curr.left != null && curr.left != root.left){
                    nextLeft = curr.left;
                    break;
                }
                 if(curr.right != null){
                    nextLeft = curr.right;
                    break;
                }
                curr = curr.next;
            }
        }
        // calculating next pointer for the right node to be passed in the next recusrive call
        if(root.right != null){
            Node curr = root;
            while(curr != null){
                if(curr.left != null && curr.left != root.left){
                    nextRight = curr.left;
                    break;
                }
                 if(curr.right != null && curr.right != root.right){
                    nextRight = curr.right;
                    break;
                }
                curr = curr.next;
            }
        }
        preorder(root.left, nextLeft);
        preorder(root.right, nextRight);
    }
}

/************************************************************************************************************************/
//Approach 2 : Using previous level pointer approach
//Time : o(n) and space : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/* Though the solution is accepted and optimized in terms of space and time but has lot of if else check.
Not sure if it is possible to have more cleaner code?
Let me know if you see any optimization or improvements in the below code*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node leftMost = root;
        while(leftMost != null){
            Node prev = leftMost;
            Node curr = null; // Find the first not null node in the next level
            while(prev != null){
                if(prev.left != null){
                    curr = prev.left;
                    break;
                }
                else if(prev.right != null){
                    curr = prev.right;
                    break;
                }
                prev = prev.next;
            }
            // Found first not null node in the next level and stored in curr variable
            Node nextLeftMost = curr; //save the first not null node in next level into temp variable ,
                                      //so that we can initialise the leftmost variable for next iteration
            // make bridges in the curr level by finding next not null node in the curr level (using prev level to move in curr level)
            while(prev != null){
                //if the current node is left or right child of prev then we cannot use left child of previous
                // check for right child of previous node or  move previous
                if(prev.left != null && prev.left != curr && prev.right != curr){
                    curr.next = prev.left;
                    curr = curr.next;
                }
                //  we can use prev right child if curr is left child of prev else if curr is right child  of previous then ignore and move previous
                else if(prev.right != null && prev.right != curr){
                    curr.next = prev.right;
                    curr = curr.next;
                }
                else{
                    prev = prev.next;
                }
            }
            leftMost = nextLeftMost;
        }
        return root;
    }
}
