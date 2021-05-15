//recover binary search Tree

//tc - O(n)
// sc- O(n)
import java.util.*;
public class Problem2 {
    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        Problem2 p = new Problem2();
        p.recoverTree(root);
        while(root != null){
            System.out.println(root.val);
            root = root.left;
        }
    }
    List<Integer> ls = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root);
        int[] swapped = swappedNodes();
        createTree(root, 2, swapped[0], swapped[1]);

    }
    public void createTree(TreeNode root, int count, int x, int y){
        if(root != null){
            if(root.val == x || root.val ==y){
                root.val = root.val == x? y :x;
                if(--count ==0)
                    return;
            }
            createTree(root.left, count, x, y);
            createTree(root.right, count, x, y);

        }
    }
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        ls.add(root.val);
        inorder(root.right);
    }
    public int[] swappedNodes(){
        int x = -1;
        int y =  -1;
        for(int i = 0;i< ls.size()-1;i++){
            if(ls.get(i) > ls.get(i+1)){
                y = ls.get(i+1);
                if(x == -1){
                    x = ls.get(i);
                }
                else{
                    break;
                }
            }

        }
        return new int[]{x,y};

    }

    
}
