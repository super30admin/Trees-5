// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

#include <iostream>

using namespace std;

// Definition for a binary tree node.
struct Node {
    int val;
    Node* left;
    Node* right;
    Node* next;
    Node(int x) : val(x), left(nullptr), right(nullptr), next(nullptr) {}
};

class Solution {
public:
    Node* connect(Node* root) {
        Node* level = root;

        while (level != nullptr) {
            Node* cur = level;

            while (cur != nullptr) {
                if (cur->left != nullptr) {
                    cur->left->next = cur->right;
                }

                if (cur->right != nullptr && cur->next != nullptr) {
                    cur->right->next = cur->next->left;
                }

                cur = cur->next;
            }

            level = level->left;
        }

        return root;
    }
};
