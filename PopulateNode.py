# -*- coding: utf-8 -*-
"""
Created on Tue Feb 25 03:23:24 2020

@author: WELCOME
"""
"""
Populate
Time - O(N)
Space - O(1)
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        temp=root
        parent=root
        while(temp.left):
            parent=temp
            while(parent):
                parent.left.next=parent.right
                if parent.next:
                    parent.right.next=parent.next.left
                parent=parent.next
            temp=temp.left
        return root