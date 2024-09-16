# -*- coding: utf-8 -*-
"""
TC:O(N) N is the no of nodes, we traverse through the tree, visit all nodes
SC:O(H) recursive stack
"""

class Solution:
    def check(self, cur, prv):
        if prv != None and prv.val > cur.val:
            if self.second is None:
                self.first = prv
            self.second = cur

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        cur = root
        prv = None
        self.first = None
        self.second = None
        #DFS with const space
        while cur!= None:
            if cur.left == None:
				#print(cur.val)
                self.check(cur, prv)
                prv = cur
                cur = cur.right
            else:
                p = cur.left
                while p.right != None and p.right != cur:
                    p = p.right
                if p.right == cur:
                    p.right = None
                    self.check(cur, prv)
                    prv = cur
                    cur = cur.right
                else:
                    p.right = cur
                    cur = cur.left
        self.first.val, self.second.val = self.second.val, self.first.val
        return root