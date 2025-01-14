#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 50010;

int n, m;
int cnt[N];
int top_k[N];

int main() {
    scanf("%d%d", &n, &m);

    int k = 0;
    for (int i = 0; i < n; ++i) {
        int id;
        scanf("%d", &id);

        if (i) {
            printf("%d:", id);
            for (int j = 0; j < k; j++) printf(" %d", top_k[j]);
            printf("\n");
        }

        bool flag = false;
        for (int j = 0; j < k; ++j)
            if (top_k[j] == id) {
                flag = true;
                break;
            }
        if (!flag) top_k[k++] = id;
        cnt[id]++;

        sort(top_k, top_k + k, [](int &a, int &b) {
            if (cnt[a] != cnt[b]) return cnt[a] > cnt[b];
            else return a < b;
        });
        k = min(k, m);
    }
    return 0;
}
