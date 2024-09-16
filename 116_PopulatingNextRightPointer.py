# BFS Solution
# Time Complexity: O(n)
# space Complexity: O(n)

# optimize BFS
# Time Complexity: O(n)
# space Complexity: O(1)


# """
# # Definition for a Node.
# class Node:
#     def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
#         self.val = val
#         self.left = left
#         self.right = right
#         self.next = next
# """


class Solution:
    # BFS ----------------->
    # make a queue
    # go level wise
    # when we are at first node, we set that node as curr -> that node is coming from queue
    # when we are at second node, we set curr as previous and prev.next = curr 
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return root
        q = []
        q.append(root)
        while q:
            size = len(q)
            prev = Node()
            curr = Node()
            for i in range(0,size):
                curr = q.pop(0)
                if i != 0:
                    prev.next = curr
                if curr.left != None:
                    q.append(curr.left)
                    q.append(curr.right)
                prev = curr
        return root
        
    # optimize BFS ----------------->
    # don't maintain queue
    # use level and curr 
    # here, level is increasing by giving root.left after finishing that level
    # for ex,
    #               50
    #           /         \
    #          30          70
    #       /     \      /     \
    #      20     40    65      80
    # so, first level = 0 is root = 50
    # so to find next(30 --> 70) of root.left , we will connect through the root
    # root.right is next of root.left
    # --> root.right(70) is next of root.left
    # now,...
    # we will go at level = 1 = root.left = 30
    # here root.left is also """curr = 30""
    # curr.left = 20, it's next is (curr.right) 20 --> 40
    # now next of 40 is 65
    # to connect with that, we will go over curr.next(70) and take it's right(65)
    # curr.right.next = curr.next.right 
    # we do this until level is not finish
    # once level finish we go to next level......
    def connect2(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return root
        level = root
        while level.left != None:
            curr = level
            while curr != None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                # go to next node
                curr = curr.next
            # go to next level
            level = level.left
        return root



