#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

string s;
vector<int> a;

int main() {
    cin >> s;
    for (int i = s.size() - 1; i >= 0; i--) a.push_back(s[i] - '0');

    vector<int> b;
    int t = 0;
    for (int i = 0; i < a.size(); i++) {
        int s = a[i] + a[i] + t;
        b.push_back(s % 10);
        t = s / 10;
    }
    if (t) b.push_back(t);

    vector<int> c = b;
    sort(a.begin(), a.end());
    sort(c.begin(), c.end());
    if (a == c) puts("Yes");
    else puts("No");

    for (int i = b.size() - 1; i >= 0; i--) cout << b[i];

    return 0;
}
