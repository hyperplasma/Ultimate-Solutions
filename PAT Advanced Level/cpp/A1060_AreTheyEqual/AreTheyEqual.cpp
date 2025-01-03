#include <iostream>
#include <cstring>
#include <algorithm>
#include <algorithm>

using namespace std;

int n;
string a, b;

void convert(string &s) {
    int k = 0;
    while (k < s.size() && s[k] != '.') k++;

    if (find(s.begin(), s.end(), '.') == s.end()) s += '.';
    s = s.substr(0, k) + s.substr(k + 1);
    while (s[0] == '0') s = s.substr(1), k--;

    while (s.size() < n) s += '0';
    s = s.substr(0, n);
    if (stod(s) == 0) k = 0;
    s = "0." + s + "*10^" + to_string(k);
}

int main() {
    cin >> n >> a >> b;
    convert(a);
    convert(b);

    if (a == b) cout << "YES " << a << endl;
    else cout << "NO " << a << " " << b << endl;

    return 0;
}
