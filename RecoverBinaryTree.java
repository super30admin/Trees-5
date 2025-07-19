//time complexity- O(n) where n is the number of tree nodes
//space complexity- O(n) for recursive stack space
public class RecoverBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    static TreeNode prev = null;
    static TreeNode first = null;
    static TreeNode sec = null;
    static void recoverTree(TreeNode root) {
        inorder(root);
        first.val = first.val ^ sec.val;
        sec.val = first.val ^ sec.val;
        first.val = first.val ^ sec.val;
    }
    private static void inorder(TreeNode node) {
        if(node == null) return;

        inorder(node.left);
        if(prev != null && prev.val >= node.val) {
            if(first == null) first = prev;
            sec = node;
        }
        prev = node;
        inorder(node.right);
    }
    static  void print(TreeNode node) {
        if(node != null) {
            print(node.left);
            System.out.print(node.val + "   ");
            print(node.right);
        }
    }
    public static void main(String[] args) {
        /*
                            100
                          /     \
                       50       120
                     /  \      /   \
                   20   80   110    60
                  / \  / \    \    / \
                10 30 140 90 115  130 160
         */
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(120);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(80);

        root.right.left = new TreeNode(110);
        root.right.right = new TreeNode(60);

        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(30);

        root.left.right.left = new TreeNode(140);
        root.left.right.right = new TreeNode(90);

        root.right.left.right = new TreeNode(115);

        root.right.right.left = new TreeNode(130);
        root.right.right.right = new TreeNode(160);

        System.out.println("Before recovery:");
        print(root);
        recoverTree(root);
        System.out.println("\nAfter Recovery:");
        print(root);

    }
}
