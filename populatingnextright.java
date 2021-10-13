
time complexity: O(n)
space complexity: O(1)

//trversing through the level heads and modifying the current value, to get the required value

class Solution {
    public Node connect(Node root) {
        if(root == null) //base condition
        return null;
 
    Node lastHead = root;//previous level's head 
    Node lastCurrent = null;//previous level's pointer
    Node currentHead = null;//current level's head 
    Node current = null;//current level's pointer
 
    while(lastHead!=null){
        lastCurrent = lastHead;
 
        while(lastCurrent!=null){
            if(currentHead == null){
                currentHead = lastCurrent.left;
                current = lastCurrent.left;
            }else{
                current.next = lastCurrent.left;
                current = current.next;
            }
 
            if(currentHead != null){
                current.next = lastCurrent.right;
                current = current.next;
            }
 
            lastCurrent = lastCurrent.next;
        }
 
        //updating last head
        lastHead = currentHead;
        currentHead = null;
    }
            return root;
} 
}
