#Problem3: Morris Inorder Traversal (https://leetcode.com/problems/binary-tree-inorder-traversal/)
# Time complexity: O(n),We visit every node in the tree,even though some nodes are visited twice while creating and removing the temporary links,each link is created once and removed once.so the total number of steps stays proportional to the number of nodes,this gives us O(n) overall
# Space complexity: O(1),We are not using recursion and we are not using an extra stack or list to keep track of nodes
# Approach:
# We want to visit nodes in inorder order which means left side first, then the node, then right side, normally this needs a stack or recursion to remember how to come back after visiting the left side,instead here we create a temporary link inside the tree itself to remember our way back,this link connects the rightmost node of the left subtree back to the current node,once we use that link to come back, we remove it so the tree returns to its original shape,this way we avoid using any extra memory for a stack

class Solution:
    def inorderTraversal(self, root):
        # this list will collect the values in inorder order
        # this is what we will return at the end
        result = []

        # current is the pointer we use to walk through the tree
        # we start at the root
        current = root

        # keep going until current becomes None
        # this means we have finished visiting every node
        while current is not None:

            # case 1, current has no left child
            # this means there is nothing left to visit before current
            # so we can safely add current to our result right now
            if current.left is None:
                # add the value to our result list instead of printing it
                result.append(current.val)
                # move to the right side since the left side is already done
                current = current.right

            # case 2, current has a left child
            # this means we still need to explore the left side before visiting current
            else:
                # pre will help us find the predecessor of current the predecessor is the rightmost node in current's left subtree
                pre = current.left

                # keep moving right as long as there is a right child and as long as that right child is not already linked back to current
                # this second check protects us from going in circles if the link already exists
                while pre.right is not None and pre.right != current:
                    pre = pre.right

                # if pre.right is empty, we have not created the link yet,this means this is our first time visiting current
                if pre.right is None:
                    # create the link so we know how to come back to current later
                    pre.right = current
                    # move into the left subtree to explore it first
                    current = current.left

                # if we reach here, pre.right already points back to current,this means we have already explored the entire left subtree using this link
                else:
                    # remove the link so the tree goes back to its original shape
                    pre.right = None
                    # now it is safe to add current to our result
                    result.append(current.val)
                    # add the value here too, instead of printing it
                    current = current.right
        return result