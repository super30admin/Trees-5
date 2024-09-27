//TC = O(N)
//SC = O(1)

import java.util.*;

public class PopulatingNextRightPointers {
    

    public static Node next(Node root)
    {
        if(root == null) return root;

        Node level = root;

        while(level.left!=null)
        {
            Node curr = level;

            while(curr!=null)
            {
                curr.left.next = curr.right;

                if(curr.next!=null)
                {
                    curr.right.next=curr.next.left;
                }

                curr = curr.next;
            }

            level = level.left;
        }

        return root;

    }
}
