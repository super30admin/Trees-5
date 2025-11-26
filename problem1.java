
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
There are two way of solving this problem first is to use a normal BFS and using the q.peek() to link the current popped node to
do this till size- 1 for each level that will be O(n) TC but O(n) space is also O(n)

so we can use this method we are using the cur level of the tree we are on to connect the node in the next level
        1
    /       \
    2       3
we use  1.left.next = 1.right;
then we do cur.next that will make cur = null
we will then move down one level using level.left because this level is already connected in the previous we can trverse this level easily
we will to this util level.left is not null basically till the last level

this approach only works when we have perfect tree

*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node level = root;
        while (level.left != null) {
            Node curr = level;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;

    }
}
