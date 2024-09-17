//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//runtime:
//space:
//leetcode: yes
//problems:
//explanation:
var postorder;

postorder = function(root) {
  var stack;
  stack = [];
  while (true) {
    while (root !== null) {
      stack.push(root);
      stack.push(root);
      root = root.left;
    }
    if (stack.length === 0) {
      return;
    }
  }
};

//# sourceMappingURL=template.js.map
