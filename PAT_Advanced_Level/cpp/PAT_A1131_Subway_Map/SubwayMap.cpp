#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

#define x first
#define y second

using namespace std;

typedef pair<int, int> PII;

const int N = 10010, M = 1000010;

int n;
int h[N], e[M], w[M], line[M], ne[M], idx;
int dist[N], cnt[N], pre[N];
int stops[N];
string info[N];
bool st[N];

string get_number(int x) {
    char res[5];
    sprintf(res, "%04d", x);
    return res;
}

void add(int a, int b, int c, int id) {
    e[idx] = b;
    w[idx] = c;
    line[idx] = id;
    ne[idx] = h[a];
    h[a] = idx++;
}

void dijkstra(int start, int end) {
    memset(dist, 0x3f, sizeof dist);
    memset(cnt, 0x3f, sizeof cnt);
    memset(st, 0, sizeof st);

    priority_queue <PII, vector<PII>, greater<PII>> heap;
    heap.push({0, start});
    dist[start] = cnt[start] = 0;

    while (heap.size()) {
        auto t = heap.top();
        heap.pop();

        int ver = t.y;
        if (ver == end) break;
        if (st[ver]) continue;
        st[ver] = true;

        for (int i = h[ver]; ~i; i = ne[i]) {
            int j = e[i];
            if (dist[j] > dist[ver] + w[i]) {
                dist[j] = dist[ver] + w[i];
                cnt[j] = cnt[ver] + 1;
                pre[j] = ver;
                info[j] = "Take Line#" + to_string(line[i]) + " from " +
                          get_number(ver) + " to " + get_number(j) + ".";
                heap.push({dist[j], j});
            } else if (dist[j] == dist[ver] + w[i]) {
                if (cnt[j] > cnt[ver] + 1) {
                    cnt[j] = cnt[ver] + 1;
                    pre[j] = ver;
                    info[j] = "Take Line#" + to_string(line[i]) + " from " +
                              get_number(ver) + " to " + get_number(j) + ".";
                }
            }
        }
    }

    cout << dist[end] << endl;
    vector <string> path;
    for (int i = end; i != start; i = pre[i])
        path.push_back(info[i]);

    for (int i = path.size() - 1; ~i; i--)
        cout << path[i] << endl;
}

int main() {
    cin >> n;
    memset(h, -1, sizeof h);
    for (int i = 1; i <= n; i++) {
        int m;
        cin >> m;
        for (int j = 0; j < m; j++) cin >> stops[j];

        for (int j = 0; j < m; j++)
            for (int k = 0; k < j; k++) {
                int len;
                if (stops[0] != stops[m - 1]) len = j - k;
                else len = min(j - k, m - 1 - j + k);

                add(stops[j], stops[k], len, i);
                add(stops[k], stops[j], len, i);
            }
    }

    int k;
    cin >> k;
    while (k--) {
        int start, end;
        cin >> start >> end;
        dijkstra(start, end);
    }

    return 0;
}
