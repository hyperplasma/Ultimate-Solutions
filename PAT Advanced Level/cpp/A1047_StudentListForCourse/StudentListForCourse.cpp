#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 40010, M = 2510;

int n, k;
string name[N];
vector<int> list[M];

int main() {
    scanf("%d%d", &n, &k);

    char s[7];
    for (int i = 0; i < n; ++i) {
        int num;
        scanf("%s%d", s, &num);
        name[i] = s;

        while (num--) {
            int x;
            scanf("%d", &x);
            list[x].push_back(i);
        }
    }

    for (int i = 1; i <= k; ++i) {
        printf("%d %d\n", i, list[i].size());

        sort(list[i].begin(), list[i].end(), [](int &a, int &b) {
            return name[a] < name[b];
        });
        for (auto it: list[i])
            printf("%s\n", name[it].c_str());
    }

    return 0;
}
