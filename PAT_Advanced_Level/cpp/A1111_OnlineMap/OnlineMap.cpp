#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 510;

int n, m, S, T;
vector <pair<int, int>> g1[N], g2[N];
int dist1[N], dist2[N], pre[N];
bool st[N];

pair<int, string> dijkstra(vector <pair<int, int>> g1[], vector <pair<int, int>> g2[], int flag) {
    memset(dist1, 0x3f, sizeof(dist1));
    memset(dist2, 0x3f, sizeof(dist2));
    memset(st, false, sizeof(st));
    dist1[S] = dist2[S] = 0;

    for (int i = 0; i < n; ++i) {
        int t = -1;
        for (int j = 0; j < n; ++j)
            if (!st[j] && (t == -1 || dist1[j] < dist1[t])) t = j;

        st[t] = true;

        auto d1 = g1[t];
        auto d2 = g2[t];
        for (int k = 0; k < d1.size(); ++k) {
            int j = d1[k].first;
            int w;
            if (flag == 0) w = d2[k].second;
            else w = 1;

            if (dist1[j] > dist1[t] + d1[k].second) {
                dist1[j] = dist1[t] + d1[k].second;
                dist2[j] = dist2[t] + w;
                pre[j] = t;
            } else if (dist1[j] == dist1[t] + d1[k].second) {
                if (dist2[j] > dist2[t] + w) {
                    dist2[j] = dist2[t] + w;
                    pre[j] = t;
                }
            }
        }
    }

    vector<int> path;
    for (int i = T; i != S; i = pre[i]) path.push_back(i);

    pair<int, string> res;
    res.first = dist1[T];
    res.second += to_string(S);
    for (int i = path.size() - 1; i >= 0; --i)
        res.second += " -> " + to_string(path[i]);

    return res;
}

int main() {
    cin >> n >> m;
    while (m--) {
        int a, b, flag, temp1, temp2;
        cin >> a >> b >> flag >> temp1 >> temp2;

        g1[a].push_back({b, temp1});
        g2[a].push_back({b, temp2});
        if (flag == 0) {
            g1[b].push_back({a, temp1});
            g2[b].push_back({a, temp2});
        }
    }

    cin >> S >> T;

    auto A = dijkstra(g1, g2, 0);
    auto B = dijkstra(g2, g1, 1);

    if (A.second != B.second) {
        cout << "Distance = " << A.first << ": " << A.second << endl;
        cout << "Time = " << B.first << ": " << B.second << endl;
    } else
        cout << "Distance = " << A.first << "; Time = " << B.first << ": " << A.second << endl;

    return 0;
}
