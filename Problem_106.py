# TC : O(N)
# SC : O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.list = []
        def inorder(root):
            if not root:
                return
            inorder(root.left)
            self.list.append(root.val)
            inorder(root.right)

        def find_nodes(list1):
            t1, t2 = None, None
            for i in range(1, len(list1)):
                if list1[i - 1] > list1[i]:
                    t2 = list1[i]
                    if t1 == None:
                        t1 = list1[i - 1]
                    else:
                        break
            return t1, t2

        def recover(r, t1, t2, count):
            if r:
                if r.val == t1 or r.val == t2:
                    r.val = t2 if r.val == t1 else t1
                    count -= 1
                    if count == 0:
                        return
                recover(r.left, t1, t2, count)
                recover(r.right, t1, t2, count)
        
        inorder(root)
        t1, t2 = find_nodes(self.list)
        print(t1, t2, self.list)
        recover(root, t1, t2, 2)