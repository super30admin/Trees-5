#https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
#runtime:
#space:
#leetcode: yes
#problems:
#explanation:

postorder = (root) ->
  stack = []

  while true
    while root isnt null
      stack.push(root)
      stack.push(root)
      root = root.left

    return if stack.length is 0
