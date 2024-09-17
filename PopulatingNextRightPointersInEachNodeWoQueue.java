import java.util.*;
/*Approach: 
1. We are manipulating the main root, so we save it in a variable and return that. 
2. The logic is that every level is already processed, so we have a link between the previous levels node. 
3. When we start off with main root, its next is already null.
4. At every level, we store the head in prevHead. Because the next traversal should start from it. 
5. If it is the last node on the level, it's next would be null. That is when we reset root to the prevHead's left.

Time complexity: O(N)
Space complexity: O(1)
*/
public class PopulatingNextRightPointersInEachNodeWoQueue {
    public Node connect(Node root) {
        if (root == null) return root;

        Node mainRoot = root;
        Node prevHead = root; 
        while(root.left!=null) //tree iteration
        {
            root.left.next = root.right;
            if(root.next!=null)
            {
                if(prevHead==null)
                    prevHead = root;
                root.right.next = root.next.left;
                root = root.next;
            }
            else
            {
                root = prevHead.left;
                prevHead = null;
            }
        }
        return mainRoot; 
    }
}