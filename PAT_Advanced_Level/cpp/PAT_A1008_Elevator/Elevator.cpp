#include <iostream>
#include <cstring>

using namespace std;

int main() {
    int n;
    cin >> n;

    int res = 0, cur = 0;
    while (n--) {
        int x;
        cin >> x;
        if (cur - x < 0) res += (x - cur) * 6 + 5;
        else res += (cur - x) * 4 + 5;
        cur = x;
    }

    cout << res << endl;

    return 0;
}
