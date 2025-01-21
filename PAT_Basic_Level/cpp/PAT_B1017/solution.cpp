#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

string s, ans;
int a[N], num;
int b, r;

int main() {
    cin >> s >> b;

    for (int i = s.size() - 1; i >= 0; i--) a[num++] = s[i] - '0';
    num--;

    bool flag = false;
    while (num >= 0) {
        r = r * 10 + a[num--];
        if (r / b == 0) {
            if (flag) ans = ans + "0";
        } else {
            flag = true;
            ans = ans + to_string(r / b);
            r %= b;
        }
    }

    if (!flag) ans = "0";          //测试点1：商为0
    cout << ans << " " << r;

    return 0;
}
