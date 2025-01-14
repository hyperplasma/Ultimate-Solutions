#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int len, k;
string s;

bool is_prime(int x) {
    if (x <= 1) return false;
    for (int i = 2; i <= x / i; ++i)
        if (x % i == 0)
            return false;
    return true;
}

int main() {
    cin >> len >> k >> s;

    for (int i = 0; i < len - k + 1; ++i) {
        string res = s.substr(i, k);
        if (is_prime(stoi(res))) {
            while (res.size() < k)
                res = "0" + res;    // 补前导0
            cout << res;
            return 0;
        }
    }

    puts("404");
    return 0;
}
