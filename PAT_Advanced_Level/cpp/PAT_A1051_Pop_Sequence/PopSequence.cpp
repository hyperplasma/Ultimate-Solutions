#include <iostream>
#include <cstring>
#include <algorithm>
#include <stack>

using namespace std;

const int MAXN = 1010;

int m, n, k;         // m: 栈容量，n: 数字，k: 测试例数量

int main(void) {
    cin >> m >> n >> k;

    while (k--) {
        stack<int> s;
        int num[MAXN];
        for (int i = 0; i < n; ++i) cin >> num[i];

        int pos = 0, flag = 0;
        for (int i = 1; i <= n; ++i) {
            s.push(i);
            if (s.size() > m) {
                flag = 1;
                break;
            }
            while (!s.empty() && num[pos] == s.top()) {
                ++pos;
                s.pop();
            }
        }

        if (flag == 0 && s.empty()) printf("YES\n");
        else printf("NO\n");
    }

    return 0;
}
