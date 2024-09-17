//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//runtime: O(n)
//space: O(diameter of tree)
//leetcode: yes
//problems: none
//explanation:
///**
// * // Definition for a Node.
//* function Node(val, left, right, next) {
//*    this.val = val === undefined ? null : val;
//*    this.left = left === undefined ? null : left;
//*    this.right = right === undefined ? null : right;
//*    this.next = next === undefined ? null : next;
//* };
//*/

//  /**
// * @param {Node} root
// * @return {Node}
// */
var connect;

connect = function(root) {
  var curr, level;
  if (root === null) {
    return root;
  }
  curr = root;
  level = root;
  while (level.left !== null) {
    curr = level;
    while (curr !== null) {
      curr.left.next = curr.right;
      if (curr.next !== null) {
        curr.right.next = curr.next.left;
      }
      curr = curr.next;
    }
    level = level.left;
  }
  return root;
};

//# sourceMappingURL=problem1-next-right-pointer.js.map
