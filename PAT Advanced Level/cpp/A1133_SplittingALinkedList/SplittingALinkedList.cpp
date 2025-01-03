#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010;

int n, k, head;

struct Node {
    int ad, data, next;
    int flag;    // <0: 2，[0, k]: 1，>k: 0
    int num;

    bool operator<(const Node &t) const {
        if (flag != t.flag) return flag > t.flag;
        else return num < t.num;
    }
} nodes[N];

vector <Node> L;

int main() {
    scanf("%d%d%d", &head, &n, &k);
    for (int i = 0; i < n; ++i) {
        int ad, data, next, flag;
        scanf("%d%d%d", &ad, &data, &next);

        if (data < 0) flag = 2;
        else if (0 <= data && data <= k) flag = 1;
        else flag = 0;

        nodes[ad] = {ad, data, next, flag, 0};
    }

    int cnt = 1;
    for (int p = head; p != -1; p = nodes[p].next) {
        nodes[p].num = cnt++;
        L.push_back(nodes[p]);
    }
    sort(L.begin(), L.end());

    for (int i = 0; i < L.size() - 1; ++i)
        printf("%05d %d %05d\n", L[i].ad, L[i].data, L[i + 1].ad);
    printf("%05d %d -1\n", L[L.size() - 1].ad, L[L.size() - 1].data);

    return 0;
}
