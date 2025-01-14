#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

typedef long long ll;

int d;
ll a, b;

int main() {
    cin >> a >> b >> d;
    ll c = a + b;

    vector<int> res;
    while (c) {
        res.push_back(c % d);
        c /= d;
    }

    if (res.empty()) cout << 0;
    for (int i = res.size() - 1; i >= 0; --i)
        cout << res[i];

    return 0;
}
