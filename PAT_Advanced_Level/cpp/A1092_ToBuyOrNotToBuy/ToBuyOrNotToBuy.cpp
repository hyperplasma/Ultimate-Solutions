#include <iostream>
#include <cstring>
#include <unordered_map>

using namespace std;

string a, b;
unordered_map<char, int> mp;

int main() {
    cin >> a >> b;

    for (auto c: a) mp[c]++;
    for (auto c: b) mp[c]--;

    int n1 = 0, n2 = 0;
    for (auto it: mp) {
        if (it.second > 0) n1 += it.second;
        else n2 -= it.second;
    }

    if (n2 > 0) cout << "No " << n2 << endl;
    else cout << "Yes " << n1 << endl;

    return 0;
}
