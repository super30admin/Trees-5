import java.util.*;
/*Approach: 
1. Do the elevl order traversal. 
2. Save the previous node. If the previous node is null, we are seeing the first node of the level. Therefore it will not have a previous. 
3. After coming out of for loop/done traversing the level, set the last node's next to null

Time complexity: O(N)
Space complexity: O(N). This is a perfect binary tree which means the last level contains N/2 nodes.
*/
public class PopulatingNextRightPointersInEachNode {
    Queue<Node> queue = new LinkedList<>();
    public Node connect(Node root) {
        if(root==null)
            return null;
        queue.add(root);
        levelOrderTraversal(root);
        return root;
    }
    
    private void levelOrderTraversal(Node root)
    {
        Node currentNode = null; Node prevNode;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            prevNode = null;
            for(int i = 0; i<= size-1; i++)
            {
                currentNode = queue.remove();
                if(prevNode!=null)
                    prevNode.next = currentNode;
                if(currentNode.left!=null && currentNode.right!=null)
                {
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                }
                prevNode =  currentNode;
            }
            currentNode.next = null;
        }
    }
}