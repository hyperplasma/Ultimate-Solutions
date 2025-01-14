#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

bool judge(int res, int k) {
    string s = to_string(res), sub = to_string(k);
    for (int i = 0; i < s.length() && i < sub.length(); i++)
        if (s[s.length() - 1 - i] != sub[sub.length() - 1 - i])
            return false;
    return true;
}

int main() {
    int m;
    scanf("%d", &m);
    while (m--) {
        int k;
        scanf("%d", &k);

        bool flag = false;
        for (int n = 1; n < 10; n++) {
            int res = n * k * k;
            if (judge(res, k)) {
                printf("%d %d\n", n, res);
                flag = true;
                break;
            }
        }
        if (!flag) printf("No\n");
    }

    return 0;
}
