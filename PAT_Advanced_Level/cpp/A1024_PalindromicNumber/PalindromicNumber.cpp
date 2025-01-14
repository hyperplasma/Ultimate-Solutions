#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

bool check(vector<int> &num) {
    for (int i = 0, j = num.size() - 1; i < j; i++, j--)
        if (num[i] != num[j]) return false;
    return true;
}

vector<int> add(vector<int> &a, vector<int> &b) {
    vector<int> c;
    int t = 0;
    for (int i = 0; i < a.size() || i < b.size() || t; i++) {
        int s = t;
        if (i < a.size()) s += a[i];
        if (i < b.size()) s += b[i];
        c.push_back(s % 10);
        t = s / 10;
    }
    return c;
}

int main() {
    string n;
    int k;
    cin >> n >> k;

    vector<int> a;
    for (int i = n.size() - 1; i >= 0; i--) a.push_back(n[i] - '0');

    int cnt = 0;
    if (!check(a)) {
        while (cnt < k) {
            vector<int> b(a.rbegin(), a.rend());
            a = add(a, b);
            cnt++;
            if (check(a)) break;
        }
    }

    for (int i = a.size() - 1; i >= 0; i--) cout << a[i];

    cout << endl << cnt << endl;

    return 0;
}
