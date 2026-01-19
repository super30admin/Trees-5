// Problem - Populating Next Right Pointers in Each Node
//  Time Complexity : O(n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We do a BFS traversal level by level, and use the size apporach to
// populate right pointers
// 2. If the ith node is not the last node, we set it to q.front()
// 3. In the end we return the root

#include <iostream>
using namespace std;

class Node {
public:
  int val;
  Node *left;
  Node *right;
  Node *next;

  Node() : val(0), left(NULL), right(NULL), next(NULL) {}

  Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

  Node(int _val, Node *_left, Node *_right, Node *_next)
      : val(_val), left(_left), right(_right), next(_next) {}
};

class Solution {
public:
  Node *connect(Node *root) {
    if (!root)
      return root;
    queue<Node *> q;
    q.push(root);
    while (!q.empty()) {
      int sz = q.size();
      for (int i = 0; i < sz; i++) {
        auto front = q.front();
        q.pop();
        if (i != sz - 1) {
          front->next = q.front();
        }
        if (front->left) {
          q.push(front->left);
        }
        if (front->right) {
          q.push(front->right);
        }
      }
    }
    return root;
  }
};
