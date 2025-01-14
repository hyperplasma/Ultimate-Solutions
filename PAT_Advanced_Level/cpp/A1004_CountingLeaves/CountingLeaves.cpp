#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

const int N = 110;

int n, m;
vector<int> tr[N];
int cnt[N], level = 0;

void bfs(int u) {
    queue<int> q;
    q.push(u);

    while (!q.empty()) {
        int size = q.size();
        while (size--) {
            int t = q.front();
            q.pop();

            if (tr[t].empty()) cnt[level]++;
            else {
                for (auto child: tr[t])
                    q.push(child);
            }
        }
        level++;
    }
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int id, k;
        scanf("%d%d", &id, &k);

        while (k--) {
            int child;
            scanf("%d", &child);
            tr[id].push_back(child);
        }
    }

    bfs(1);
    for (int i = 0; i < level; ++i) {
        if (i > 0) printf(" ");
        printf("%d", cnt[i]);
    }

    return 0;
}
