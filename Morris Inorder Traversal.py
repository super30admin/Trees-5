# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Solution : Morris InOrder Traversal - No stack
    - Link predecessor of each root node to root node. Make use of predecessor's empty
      right pointer (as it will be a leaf node)
        - Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
            - Link 7'right to 1
Time Complexity: O(N)
Space Complexity: O(1)
'''
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        inOrderList = []
        current_node = root
        
        while current_node!=None:
            if current_node.left!=None:
                predecessor_node = current_node.left 
                # find the node that comes before the current node in inOrder
                while predecessor_node.right!=None and predecessor_node.right!=current_node:
                    predecessor_node = predecessor_node.right
                if predecessor_node.right==None: # if while loop ended with first condition
                    predecessor_node.right = current_node
                    current_node = current_node.left
                else:
                    predecessor_node.right=None # remove the link that we had created
                    inOrderList.append(current_node.val) # here root pops out
                    current_node = current_node.right
            else:
                inOrderList.append(current_node.val) # here leftmost node of subtree pops out
                current_node = current_node.right # use the link which connects this node's successor

        return inOrderList