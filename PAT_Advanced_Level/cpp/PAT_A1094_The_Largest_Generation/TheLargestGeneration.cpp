#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

const int N = 110;

int n, m;
vector<int> tr[N];        // [1, n]

void bfs(int u) {
    queue<int> q;
    q.push(u);

    int maxsize = 0, cnt = 0, maxcnt = 0;
    while (!q.empty()) {
        cnt++;
        int size = (int) q.size();
        if (size > maxsize) {
            maxsize = size;
            maxcnt = cnt;
        }

        while (size--) {
            int t = q.front();
            q.pop();
            for (auto it: tr[t])
                q.push(it);
        }
    }

    printf("%d %d\n", maxsize, maxcnt);
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int id, k;
        scanf("%d%d", &id, &k);

        while (k--) {
            int son;
            scanf("%d", &son);
            tr[id].push_back(son);
        }
    }

    bfs(1);
    return 0;
}
