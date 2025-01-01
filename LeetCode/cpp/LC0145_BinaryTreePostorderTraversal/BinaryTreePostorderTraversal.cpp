#include <iostream>
#include "TreeNode.h"

using namespace std;

class Solution {
public:
    void DFS(TreeNode *u, vector<int> &res) {
        if (u) {
            DFS(u->left, res);
            DFS(u->right, res);
            res.push_back(u->val);
        }
    }

    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        DFS(root, res);
        return res;
    }
};