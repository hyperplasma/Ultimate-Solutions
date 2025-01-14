#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;

const int N = 40;

int n;
int root, l[N], r[N];
vector<int> postorder;

void dfs(int u) {
    if (!u) return;

    dfs(l[u]);
    dfs(r[u]);
    postorder.push_back(u);
}

void print() {
    for (int i = 0; i < postorder.size(); ++i) {
        if (i > 0) printf(" ");
        cout << postorder[i];
    }
}

int main() {
    cin >> n;

    stack<int> stk;
    int last_node = 0;
    string last_op;
    for (int i = 0; i < 2 * n; ++i) {
        string op;
        cin >> op;

        if (op == "Push") {
            int node;
            cin >> node;

            if (!last_node) {
                root = node;
            } else {
                if (last_op == "Push") l[last_node] = node;
                else r[last_node] = node;
            }

            last_node = node;
            stk.push(node);
        } else {
            int node = stk.top();
            stk.pop();
            last_node = node;
        }
        last_op = op;
    }

    dfs(root);
    print();
}
