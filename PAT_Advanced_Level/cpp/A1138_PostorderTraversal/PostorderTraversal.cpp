#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

const int N = 50010;

int n;
unordered_map<int, int> pos;
int pre[N], in[N];
bool flag = false;

void build(int inL, int inR, int preL, int preR) {
    int root = pre[preL];
    int k = pos[root];

    if (k > inL) build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL));
    if (k < inR) build(k + 1, inR, preL + 1 + k - inL, preR);

    if (!flag) {
        cout << root;
        flag = true;
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) cin >> pre[i];
    for (int i = 0; i < n; ++i) {
        cin >> in[i];
        pos[in[i]] = i;
    }

    build(0, n - 1, 0, n - 1);

    return 0;
}
