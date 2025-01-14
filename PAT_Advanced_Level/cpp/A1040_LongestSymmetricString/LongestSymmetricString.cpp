#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int main() {
    string s;
    getline(cin, s);

    int res = 0;
    for (int i = 0; i < s.size(); ++i) {
        int l = i - 1, r = i + 1;    // 奇数长度
        while (l >= 0 && r < s.size() && s[l] == s[r]) l--, r++;
        res = max(res, r - l + 1 - 2);

        l = i, r = i + 1;
        while (l >= 0 && r < s.size() && s[l] == s[r]) l--, r++;
        res = max(res, r - l + 1 - 2);
    }

    cout << res << endl;

    return 0;
}
