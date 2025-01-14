#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 10010;

int n, m, S, T;
vector<int> g[N];
bool is_girl[N];

struct Friends {
    int a, b;

    bool operator<(const Friends &t) const {
        if (a != t.a) return a < t.a;
        else return b < t.b;
    }
};

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        string stra, strb;
        cin >> stra >> strb;

        if (stra[0] == '-') {
            stra = stra.substr(1);
            is_girl[stoi(stra)] = true;
        }
        if (strb[0] == '-') {
            strb = strb.substr(1);
            is_girl[stoi(strb)] = true;
        }

        int a = stoi(stra), b = stoi(strb);
        g[a].push_back(b);
        g[b].push_back(a);
    }

    int Q;
    scanf("%d", &Q);
    while (Q--) {
        scanf("%d%d", &S, &T);
        S = abs(S);
        T = abs(T);

        vector <Friends> res;
        for (auto i: g[S])
            if (is_girl[S] == is_girl[i] && i != T) { // 排除"S->T"一步到位的情况！！
                for (auto j: g[i])
                    if (is_girl[j] == is_girl[T] && j != S) { // 同上
                        for (auto k: g[j])
                            if (k == T) {
                                res.push_back({i, j});
                                break;
                            }
                    }
            }

        printf("%d\n", res.size());

        if (!res.empty()) sort(res.begin(), res.end());
        for (auto it: res)
            printf("%04d %04d\n", it.a, it.b);
    }

    return 0;
}
