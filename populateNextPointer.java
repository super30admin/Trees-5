// Time Complexity : O(N) N = number of nodes in the tree
// Space Complexity : O(N) N = number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
	1. Loop through the tree and add the element in the arraylist
	2. At the end of each row add null
	3. Connect the nodes in the arraylist to their adjecent values
*/


// Your code here along with comments explaining your approach
class Solution {
    ArrayList<Node> nodes = new ArrayList<>();
    Node curr;
    public Node connect(Node root) {
        nodes.add(root);
        nodes.add(null);
        
        while(!nodes.isEmpty() && isNotAllNull()) {
            int len = nodes.size();
            for(int i=0;i<len;i++) {  
                curr = nodes.remove(0);
                if(curr != null) {
                    if(!nodes.isEmpty()) {
                        curr.next = nodes.get(0);
                    }
                    if(curr.left != null) nodes.add(curr.left);
                    if(curr.right != null) nodes.add(curr.right);
                }
            }
            nodes.add(null);
        }
        return root;
    }
    
    public boolean isNotAllNull() {
        if(nodes.size() == 1 && nodes.get(0) == null) return false; 
        if(nodes.size() > 1 && nodes.get(0) == null && nodes.get(1) == null) return false; 
        return true;
    }
}
