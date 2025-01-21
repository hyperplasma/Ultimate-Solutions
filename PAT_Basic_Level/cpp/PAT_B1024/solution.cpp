#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string s, res;

int main() {
    cin >> s;

    int pos = -1;
    for (int i = 1; i < s.length(); i++) {
        if (isdigit(s[i])) res += s[i];
        if (s[i] == 'E') {
            pos = i;
            break;
        }
    }

    int len = res.size() - 1;
    int exp = stoi(s.substr(pos + 2));
    if (s[pos + 1] == '-') {
        for (int i = 0; i < exp; i++)
            res = '0' + res;
        res.insert(1, ".");
    } else {
        for (int i = 0; i < exp - len; i++)
            res = res + '0';
        if (exp < len) res.insert(1 + exp, ".");
    }

    if (s[0] == '-') res = s[0] + res;
    cout << res;

    return 0;
}
