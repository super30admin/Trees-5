#https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
#runtime: O(n)
#space: O(diameter of tree)
#leetcode: yes
#problems: none
#explanation:
#/**
# * // Definition for a Node.
#* function Node(val, left, right, next) {
#*    this.val = val === undefined ? null : val;
#*    this.left = left === undefined ? null : left;
#*    this.right = right === undefined ? null : right;
#*    this.next = next === undefined ? null : next;
#* };
#*/
#
#  /**
# * @param {Node} root
# * @return {Node}
# */
connect = (root) ->
  return root if root is null

  curr = root
  level = root

  while level.left isnt null
    curr = level
    while curr isnt null
      curr.left.next = curr.right
      if curr.next isnt null
        curr.right.next = curr.next.left

      curr = curr.next
    level = level.left

  root
