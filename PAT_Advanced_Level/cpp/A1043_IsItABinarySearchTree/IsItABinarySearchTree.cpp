#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 1010;

int n;        // 左小 右大等
int pre[N], in[N];
vector<int> post;

bool build(int inL, int inR, int preL, int preR, int flag) {
    if (inL > inR) return true;

    int k;
    if (flag == 0) {
        for (k = inL; k <= inR; ++k)
            if (in[k] == pre[preL]) break;

        if (k > inR) return false;
    } else {
        for (k = inR; k >= inL; --k)
            if (in[k] == pre[preL]) break;

        if (k < inL) return false;
    }

    bool res = true;
    if (!build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL), flag))
        res = false;
    if (!build(k + 1, inR, preL + 1 + (k - 1 - inL) + 1, preR, flag))
        res = false;

    post.push_back(pre[preL]);
    return res;
}

void print() {
    for (int i = 0; i < post.size(); ++i) {
        if (i > 0) cout << " ";
        cout << post[i];
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> pre[i];
        in[i] = pre[i];
    }
    sort(in, in + n);

    if (build(0, n - 1, 0, n - 1, 0)) {
        cout << "YES" << endl;
        print();
    } else {
        reverse(in, in + n);
        post.clear();
        if (build(0, n - 1, 0, n - 1, 1)) {
            cout << "YES" << endl;
            print();
        } else cout << "NO" << endl;
    }

    return 0;
}
