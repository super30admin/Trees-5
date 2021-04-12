// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//TC: O(n)
//SC: O(1)
//1st if 
//parent connects left children to right children.
//2nd if
//parent's child connects its right child to sibling's left child
//Repeat for all generations(levels). 
class Solution {
    public Node connect(Node root1) {
        if(root1 == null) return null;
        Node main = root1;
        while(main != null ){
            Node root = main;
            if(root.left == null && root.right == null)
                break;
            while(root!= null){
                if(root.left != null )
                    root.left.next = root.right;
                
                if(root.next != null && root.right != null)
                    root.right.next = root.next.left;
                
                root = root.next;
            }
            main = main.left;
        }
        return root1;
    }
}

//Based on S30 class work