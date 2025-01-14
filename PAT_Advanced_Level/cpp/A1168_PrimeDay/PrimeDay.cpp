#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string s;
bool flag = true;

bool is_prime(string s) {
    int n = 0;
    if (!s.empty()) n = stoi(s);

    if (n <= 1) return false;
    for (int i = 2; i <= n / i; ++i)
        if (n % i == 0)
            return false;
    return true;
}

int main() {
    cin >> s;
    s = "1" + s;

    while (!s.substr(1).empty()) {
        s = s.substr(1);

        cout << s;
        if (is_prime(s)) cout << " Yes" << endl;
        else {
            cout << " No" << endl;
            flag = false;
        }
    }

    if (flag) cout << "All Prime!" << endl;
    return 0;
}
