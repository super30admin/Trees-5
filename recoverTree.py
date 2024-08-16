class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def recoverTree(root: TreeNode) -> None:
    # Initialize pointers needed for Morris traversal
    first = second = prev = pred = None
    
    # Morris Inorder Traversal
    while root:
        if root.left:
            # Find the predecessor
            pred = root.left
            while pred.right and pred.right != root:
                pred = pred.right
            
            # Make root the right child of its predecessor
            if not pred.right:
                pred.right = root
                root = root.left
            else:
                # If pred.right is already pointing to root, revert the changes
                if prev and prev.val > root.val:
                    if not first:
                        first = prev
                    second = root
                
                prev = root
                
                pred.right = None
                root = root.right
        else:
            if prev and prev.val > root.val:
                if not first:
                    first = prev
                second = root
            
            prev = root
            root = root.right
    
    # Swap the values of the two nodes to fix the BST
    if first and second:
        first.val, second.val = second.val, first.val

#time = O(N)
#space = O(1)