# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Node firstNodelevel = root;

        while(firstNodelevel.left != null){
            Node cursor = firstNodelevel;


            while(cursor != null){
                cursor.left.next = cursor.right;
                if(cursor.next != null){
                    cursor.right.next = cursor.next.left;
                }

                cursor = cursor.next;
            }

            firstNodelevel = firstNodelevel.left;
        }
        return root;

    }
}