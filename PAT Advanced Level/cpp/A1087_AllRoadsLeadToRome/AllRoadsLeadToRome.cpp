#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

const int N = 210;

int n, k;
int w[N];
int g[N][N];    // 道路花费
int dist[N], happy[N], cnt[N], num[N], pre[N];        // cnt[] : 最短条数
bool st[N];

string city[N];
unordered_map<string, int> mp;

void dijkstra() {
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0;
    cnt[1] = 1;

    for (int i = 0; i < n; ++i) {
        int t = -1;
        for (int j = 1; j <= n; ++j)
            if (!st[j] && (t == -1 || dist[j] < dist[t]))
                t = j;

        st[t] = true;

        for (int j = 1; j <= n; ++j) {
            if (dist[j] > dist[t] + g[t][j]) {
                dist[j] = dist[t] + g[t][j];
                cnt[j] = cnt[t];
                happy[j] = happy[t] + w[j];
                num[j] = num[t] + 1;
                pre[j] = t;
            } else if (dist[j] == dist[t] + g[t][j]) {
                cnt[j] += cnt[t];
                if (happy[j] < happy[t] + w[j]) {
                    happy[j] = happy[t] + w[j];
                    num[j] = num[t] + 1;
                    pre[j] = t;
                } else if (happy[j] == happy[t] + w[j] && num[j] > num[t] + 1) {
                    num[j] = num[t] + 1;
                    pre[j] = t;
                }
            }
        }
    }
}

int main() {
    memset(g, 0x3f, sizeof g);

    cin >> n >> k >> city[1];
    mp[city[1]] = 1;
    for (int i = 2; i <= n; ++i) {
        cin >> city[i] >> w[i];
        mp[city[i]] = i;
    }

    while (k--) {
        string a, b;
        int cost;
        cin >> a >> b >> cost;
        g[mp[a]][mp[b]] = g[mp[b]][mp[a]] = cost;
    }

    dijkstra();

    int T = mp["ROM"];
    cout << cnt[T] << " " << dist[T] << " " << happy[T] << " " << happy[T] / num[T] << endl;

    int stk[N], top = -1;
    int x = T;
    while (x != 1) {
        stk[++top] = x;
        x = pre[x];
    }
    stk[++top] = 1;

    cout << city[stk[top--]];
    while (top != -1) cout << "->" << city[stk[top--]];
    cout << endl;

    return 0;
}
