#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int len, k;
string s;

bool is_prime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= n / i; ++i)
        if (n % i == 0) return false;
    return true;
}

int main() {
    cin >> len >> k >> s;

    for (int i = 0; i < len - k + 1; ++i) {
        string subs = s.substr(i, k);
        int x = stoi(subs);
        if (is_prime(x)) {
            cout << subs << endl;
            return 0;
        }
    }

    cout << "404" << endl;
    return 0;
}
