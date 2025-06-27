#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int main() {
    string s, res;
    cin >> s;

    bool is_minus = false;
    if (s[0] == '-') is_minus = true;
    s = s.substr(1);

    int i;
    for (i = 0; i < s.size(); ++i) {
        if (s[i] == '.') continue;
        if (s[i] == 'E') break;

        res += s[i];
    }

    int k = stoi(s.substr(i + 2));
    if (s[i + 1] == '-') {
        while (k--) res = '0' + res;
        res = res.substr(0, 1) + '.' + res.substr(1);
    } else {
        if (k < res.size() - 1) {
            res = res.substr(0, 1 + k) + '.' + res.substr(1 + k);
        } else {
            while (k >= res.size()) res += '0';
        }
    }

    if (is_minus) res = '-' + res;
    cout << res << endl;

    return 0;
}
