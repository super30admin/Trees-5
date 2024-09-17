#https://leetcode.com/problems/recover-binary-search-tree/
#runtime: O(n)
#space: O(max depth)
#leetcode: yes
#problems: i was checking stack == null instead of stack.length == 0
#explanation:
#
# inorder traverse the tree
# for each tree node
#    store the prev node
#    if prev.val > cur.val
#      save the cur.val
#    if you have 2 saved vals break immediately
# before returning, swap the 2 saved values

#/**
# * Definition for a binary tree node.
# * function TreeNode(val, left, right) {
# *     this.val = (val===undefined ? 0 : val)
# *     this.left = (left===undefined ? null : left)
# *     this.right = (right===undefined ? null : right)
# * }
# */
#/**
# * @param {TreeNode} root
# * @return {void} Do not return anything, modify root in-place instead.
# */
TreeNode = (val = -1, left = null, right = null) -> Object.assign(
  Object.create(TreeNode::),
    val: val
    left: left
    right: right
  )

swap = (x, y) ->
  temp = x.val
  x.val = y.val
  y.val = temp

recoverTree = (root) ->
  return if root is null

  stack = []
  prev = null
  x = null
  y = null

  while stack.length isnt 0 || root isnt null
    while root isnt null
      stack.push(root)
      root = root.left

    popped = stack.pop()

    if prev isnt null and prev.val > popped.val
#      console.log('invalid')
      x = popped
      if y is null
        y = prev
      else
        break # you've found both

    prev = popped

    root = popped.right

  # swap the elements then return
  swap(x, y)

#mt = TreeNode(1, TreeNode(3, null, TreeNode(2)))
mt = TreeNode(3, TreeNode(1), TreeNode(4, TreeNode(2)))
recoverTree(mt)
