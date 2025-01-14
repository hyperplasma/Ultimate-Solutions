#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10010;

int n;
string s[N];

bool cmp(string a, string b) {
    return a + b < b + a;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) cin >> s[i];

    sort(s, s + n, cmp);

    string res;
    for (int i = 0; i < n; ++i) res += s[i];

    while (res[0] == '0') res = res.substr(1);
    if (res.empty()) res = "0";
    cout << res << endl;

    return 0;
}
