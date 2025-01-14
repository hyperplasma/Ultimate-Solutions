#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

struct BigN {
    int d[1010];
    int len;

    BigN() {
        memset(d, 0, sizeof d);
        len = 0;
    }
};

void init(BigN &a, string s) {
    for (int i = 0; i < s.size(); ++i)
        a.d[a.len++] = s[s.size() - 1 - i] - '0';
}

BigN add(BigN &a, BigN &b) {
    BigN c;

    int carry = 0;
    for (int i = 0; i < a.len || i < b.len; ++i) {
        carry += a.d[i] + b.d[i];
        c.d[c.len++] = carry % 10;
        carry /= 10;
    }

    if (carry) c.d[c.len++] = carry;
    return c;
}

bool check(string s) {
    for (int i = 0; i < s.size(); ++i)
        if (s[i] != s[s.size() - 1 - i]) return false;

    return true;
}

int main() {
    string s1;
    cin >> s1;

    if (check(s1)) cout << s1 << " is a palindromic number." << endl;
    else {
        int cnt = 0;
        bool flag = false;
        while (cnt < 10) {
            string s2 = s1, s3;
            reverse(s2.begin(), s2.end());

            BigN a, b, c;
            init(a, s1);
            init(b, s2);
            c = add(a, b);

            for (int i = c.len - 1; i >= 0; --i)
                s3 += to_string(c.d[i]);

            cout << s1 << " + " << s2 << " = " << s3 << endl;
            if (check(s3)) {
                cout << s3 << " is a palindromic number." << endl;
                flag = true;
                break;
            }
            cnt++;
            s1 = s3;
        }

        if (!flag) cout << "Not found in 10 iterations." << endl;
    }
    return 0;
}
