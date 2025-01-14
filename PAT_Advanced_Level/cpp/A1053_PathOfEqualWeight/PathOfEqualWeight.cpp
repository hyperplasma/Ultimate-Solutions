#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 110;

int n, m, S;
bool g[N][N];
int w[N];
vector <vector<int>> ans;

void dfs(int u, int s, vector<int> &path) {
    bool is_leaf = true;
    for (int i = 0; i < n; ++i)
        if (g[u][i]) {
            is_leaf = false;
            break;
        }

    if (is_leaf) {
        if (s == S) ans.push_back(path);
    } else {
        for (int i = 0; i < n; ++i)
            if (g[u][i]) {
                path.push_back(w[i]);
                dfs(i, s + w[i], path);
                path.pop_back();
            }
    }
}

int main() {
    cin >> n >> m >> S;
    for (int i = 0; i < n; ++i) cin >> w[i];

    for (int i = 0; i < m; ++i) {
        int id, k;
        cin >> id >> k;

        while (k--) {
            int son;
            cin >> son;
            g[id][son] = true;
        }
    }

    vector<int> path({w[0]});
    dfs(0, w[0], path);

    sort(ans.begin(), ans.end(), greater < vector < int > > ());

    for (auto p: ans) {
        for (int i = 0; i < p.size(); ++i) {
            if (i > 0) cout << " ";
            cout << p[i];
        }
        cout << endl;
    }

    return 0;
}
