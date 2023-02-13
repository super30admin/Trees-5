#Time Complexity: O(N)
#Space Complexity: O(1)
#Did it run on leetcode: Yes

class Solution:
    def recoverTree(self, root):
        x = y = predecessor = pred = None
        
        while root:
 
            if root.left:       

                predecessor = root.left
                while predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right
                if predecessor.right is None:
                    predecessor.right = root
                    root = root.left
                else:
                    if pred and root.val < pred.val:
                        y = root
                        if x is None:
                            x = pred 
                    pred = root
                    
                    predecessor.right = None
                    root = root.right
            else:
                # check for the swapped nodes
                if pred and root.val < pred.val:
                    y = root
                    if x is None:
                        x = pred 
                pred = root
                
                root = root.right
        
        x.val, y.val = y.val, x.val