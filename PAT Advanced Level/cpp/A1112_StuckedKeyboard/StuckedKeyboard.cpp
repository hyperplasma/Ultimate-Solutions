#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

int k;
string s, res;
unordered_set<char> st;
bool flag[256], is_out[256];

int main() {
    cin >> k >> s;

    for (int i = 0; i < s.size(); ++i) {
        int j = i, cnt = 0;
        while (j < s.size() && s[j] == s[i]) j++, cnt++;

        if (!flag[s[i]] && cnt % k == 0) st.insert(s[i]);
        else {
            flag[s[i]] = true;
            if (st.count(s[i])) st.erase(s[i]);
        }

        i = j - 1;
    }

    for (int i = 0; i < s.size(); ++i) {
        if (!st.count(s[i])) res += s[i];
        else {
            res += s[i];
            if (!is_out[s[i]]) {
                is_out[s[i]] = true;
                cout << s[i];
            }

            int j = i + 1, cnt = 0;
            while (j < s.size() && s[j] == s[i] && cnt < k) j++, cnt++;
            i = j - 1;
        }
    }
    cout << endl;
    cout << res << endl;

    return 0;
}
