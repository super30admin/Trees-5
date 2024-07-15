# Time Complexity : O(n)
# Space Complexity : O(h)

class Node:
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        
        nextNode = root.next
        
        while nextNode:
            if nextNode.left:
                nextNode = nextNode.left
                break
            if nextNode.right:
                nextNode = nextNode.right
                break
            nextNode = nextNode.next
        
        if root.left:
            root.left.next = root.right if root.right else nextNode
        
        if root.right:
            root.right.next = nextNode
        
        self.connect(root.right)
        self.connect(root.left)
        
        return root

def print_tree_with_next_pointers(root):
    if not root:
        return
    
    # Start with the root node
    current = root
    
    while current:
        # Use another pointer to traverse the current level
        node = current
        next_level = None
        while node:
            print(str(node.val) + " -> ", end="")
            if node.next:
                print(str(node.next.val) + " ", end="")
            else:
                print("None", end=" ")
            
            if not next_level:
                if node.left:
                    next_level = node.left
                elif node.right:
                    next_level = node.right
            
            node = node.next
        print("")
        
        current = next_level


# Example 1
root1 = Node(1, 
            Node(2, Node(4), Node(5)), 
            Node(3, Node(6), Node(7)))
sol = Solution()
sol.connect(root1)
print_tree_with_next_pointers(root1)
# Output : 1 -> None, 2 -> 3 -> None, 4 -> 5 -> 6 -> 7 -> None

# Example 2
root2 = Node(1, 
            Node(2, None, Node(5)), 
            Node(3, None, Node(7)))
sol = Solution()
sol.connect(root2)
print_tree_with_next_pointers(root2)
# Output : 
# 1 -> None, 2 -> 3 -> None, 5 -> 7 -> None

# Example 3
root3 = Node(1, 
            Node(2, Node(4), None), 
            Node(3, Node(6), Node(7)))
sol = Solution()
sol.connect(root3)
print_tree_with_next_pointers(root3)
# Output : 
# 1 -> None, 2 -> 3 -> None, 4 -> 6 -> 7 -> None 