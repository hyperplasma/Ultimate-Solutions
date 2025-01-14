#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10010;

int n, m;

struct Person {
    string name;
    int h;

    bool operator<(const Person &t) const {
        if (h != t.h) return h > t.h;
        else return name < t.name;
    }
} p[N];

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; ++i) cin >> p[i].name >> p[i].h;

    sort(p, p + n);

    int cnt = 0;
    for (int i = 0; i < m; ++i) {
        int len = n / m;
        if (i == 0) len += n % m;    // 多余人放到最后一行

        string res;
        for (int j = 0; j < len; ++j) {
            if (j % 2 == 0) res = res + p[cnt++].name + " ";
            else res = p[cnt++].name + " " + res;
        }

        while (*res.rbegin() == ' ') res.pop_back();
        cout << res << endl;
    }

    return 0;
}
