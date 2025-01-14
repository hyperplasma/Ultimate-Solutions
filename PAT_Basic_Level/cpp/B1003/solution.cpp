#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n;
string s;

int main() {
    scanf("%d", &n);
    while (n--) {
        cin >> s;
        int flag = 0, cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag == 0) {
                if (s[i] == 'A') cnt1++;
                else if (s[i] == 'P') flag = 1;
                else flag = -1;
            } else if (flag == 1 || flag == 2) {
                if (s[i] == 'A') {
                    flag = 2;
                    cnt2++;
                } else if (flag == 2 && s[i] == 'T') flag = 3;
                else flag = -1;
            } else if (flag == 3) {
                if (s[i] == 'A') cnt3++;
                else flag = -1;
            }
        }

        if (flag < 3 || cnt3 != cnt1 * cnt2) flag = -1;

        if (flag == -1) puts("NO");
        else puts("YES");
    }

    return 0;
}
