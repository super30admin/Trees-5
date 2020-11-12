class Solution {//Time O(n)and space of O(1)
    // revise look other approach
public Node connect(Node root) {
//base case 
if(root == null)
return root;
Node leftmost = root;
while (leftmost.left != null){
Node head = leftmost ;
while(head != null){
  head.left.next = head.right ;
  if(head.next != null){
      head.right.next = head.next.left ;
  }
  head = head.next ;
}
leftmost = leftmost.left ;
}
return root;
}
}