//https://leetcode.com/problems/recover-binary-search-tree/
//runtime: O(n)
//space: O(max depth)
//leetcode: yes
//problems:
//explanation:

///**
// * Definition for a binary tree node.
// * function TreeNode(val, left, right) {
// *     this.val = (val===undefined ? 0 : val)
// *     this.left = (left===undefined ? null : left)
// *     this.right = (right===undefined ? null : right)
// * }
// */
///**
// * @param {TreeNode} root
// * @return {void} Do not return anything, modify root in-place instead.
// */
var TreeNode, mt, recoverTree, swap;

TreeNode = function(val = -1, left = null, right = null) {
  return Object.assign(Object.create(TreeNode.prototype), {
    val: val,
    left: left,
    right: right
  });
};

swap = function(x, y) {
  var temp;
  temp = x.val;
  x.val = y.val;
  return y.val = temp;
};

recoverTree = function(root) {
  var popped, prev, stack, x, y;
  if (root === null) {
    return;
  }
  stack = [];
  prev = null;
  x = null;
  y = null;
  while (stack !== null || root !== null) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    popped = stack.pop();
    if (prev !== null && prev.val > popped.val) {
      //      console.log('invalid')
      x = popped;
      if (y === null) {
        y = prev;
      } else {
        break; // you've found both
      }
    }
    prev = popped;
    root = popped.right;
  }
  // swap the elements then return
  return swap(x, y);
};

//mt = TreeNode(1, TreeNode(3, null, TreeNode(2)))
mt = TreeNode(3, TreeNode(1), TreeNode(4, TreeNode(2)));

recoverTree(mt);

//# sourceMappingURL=problem2-recover-binary-search-tree.js.map
