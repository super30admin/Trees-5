//TC = O(N Log N) 
//SC = O(N)

/*

     There is an efficient approach for this. 
     But I wanted to try brute force approach. 

     Inorder traversal is done. 
     All the elements are sorted 
     Once the elements are sorted, we insert them back to the same tree
     ensuring that the structure of the tree is not changed.

     An O(N) approach is that we maintain two pointers and switch them.

*/


import java.util.*;
public class RecoverBinarySearchTree
{
    public static ArrayList<Integer> list;
    public static int[] arr;
    public static int i=0;
    public static void recoverTree(TreeNode root)
    {
        if(root == null) return;

        list = new ArrayList<>();
        dfs(root);

        //System.out.println(list); [1, 2, 5, 4, 3, 8, 9]

        arr = new int[list.size()];

        for(int i=0;i<list.size();i++)
        {
            arr[i]=list.get(i);
        }

        Arrays.sort(arr);

        construct(root);
    }


    private static void construct(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        construct(root.left);

        root.val=arr[i];
        i++;
        construct(root.right);
    }


    public static void dfs(TreeNode root)
    {
        if(root == null) return;

        dfs(root.left);

        list.add(root.val);

        dfs(root.right);
    }

    public static void main(String args[])
    {
        TreeNode eight = new TreeNode(8);
        TreeNode four = new TreeNode(4);
        TreeNode nine = new TreeNode(9);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode five = new TreeNode(5);

        eight.left=four;
        eight.right=nine;

        four.left=two;
        four.right=three;

        two.left=one;
        two.right=five;

        recoverTree(eight);

        print(eight);


    }

    public static void print(TreeNode root)
    {
        if(root == null) return;

        print(root.left);

        System.out.print(root.val+" ");

        print(root.right);
    }
}