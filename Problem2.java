import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recoverBinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //Time :O(n)
    //Space: O(1)
    //Leetcode : Yes
    //
    //Approach:
    //1.Do a inorder traversal and whenever the current node is less than previous node then update first node to previous node,middle to
    // current node.
    // 2. Now if both the misplaced nodes are on different sides then we need to update last node to current node where bst rule is broken
    //   second time.
    // 3.Now if last node is empty i.e both misplaced nodes are adjacent to each other then replace first and middle nodes else replace first and last nodes.
    static TreeNode first,middle,last,prev;
    public static void recoverTree(TreeNode root) {
        helper(root);
        if(first!=null && last!=null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else{
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public static void helper(TreeNode node){
        if(node == null)    return;
        helper(node.left);
        if(prev!=null && node.val<=prev.val){
            if(first==null){
                first = prev;
                middle = node;
            }
            else{
                last = node;
            }
        }
        prev = node;
        helper(node.right);
    }

    //Brute Force
    // Time: O(nlog n)
    //Space : O(n)
    // LeetCode : Yes
    //
    //Approach:
    //1.Do a inorder traversal and store nodes into an array and sort it. 
    //2. Now fill the tree using new values.
    int i = 0;
    public void recoverTree2(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        helper(root,inorder);
        int[] arr = new int[inorder.size()];
        for(int j = 0;j<arr.length;j++){
            arr[j] = inorder.get(j);
        }
        Arrays.sort(arr);
        int i = 0;
        fill(root,arr);
    }
    public void fill(TreeNode node,int[] arr){
        if(node == null)    return;
        fill(node.left,arr);
        node.val = arr[i];
        i++;
        fill(node.right,arr);
    }

    public void helper(TreeNode node,List<Integer> list){
        if(node == null)    return;
        helper(node.left,list);
        list.add(node.val);
        helper(node.right,list);
    }
}
