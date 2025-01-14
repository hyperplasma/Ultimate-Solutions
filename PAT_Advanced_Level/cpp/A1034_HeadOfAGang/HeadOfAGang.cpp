#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

int n, K;
unordered_map <string, vector<pair < string, int>>>
g;
unordered_map<string, int> total;
unordered_map<string, bool> st;

int dfs(string node, vector <string> &gang) {
    st[node] = true;
    gang.push_back(node);

    int sum = 0;
    for (auto it: g[node]) {
        auto cur_node = it.first;
        sum += it.second;

        if (!st[cur_node]) sum += dfs(cur_node, gang);
    }
    return sum;
}

int main() {
    scanf("%d%d", &n, &K);

    string a, b;
    for (int i = 0; i < n; ++i) {
        int t;
        cin >> a >> b >> t;

        g[a].push_back({b, t});
        g[b].push_back({a, t});
        total[a] += t;
        total[b] += t;
    }

    vector <pair<string, int>> res;
    for (auto it: g) {
        auto node = it.first;
        vector <string> gang;
        int sum = dfs(node, gang) / 2;

        if (gang.size() > 2 && sum > K) {
            string boss = gang[0];
            for (auto &member: gang)
                if (total[member] > total[boss])
                    boss = member;
            res.push_back({boss, gang.size()});
        }
    }

    sort(res.begin(), res.end());
    printf("%d\n", res.size());
    for (auto it: res)
        printf("%s %d\n", it.first.c_str(), it.second);

    return 0;
}
