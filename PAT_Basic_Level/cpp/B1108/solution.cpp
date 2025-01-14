#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

string s, s0 = "String";
int cnt[6];
unordered_map<char, int> mp1;
unordered_map<int, char> mp2;

void init() {
    mp1['S'] = 0, mp1['t'] = 1, mp1['r'] = 2, mp1['i'] = 3, mp1['n'] = 4, mp1['g'] = 5;
    mp2[0] = 'S', mp2[1] = 't', mp2[2] = 'r', mp2[3] = 'i', mp2[4] = 'n', mp2[5] = 'g';
}

int main() {
    cin >> s;
    init();
    for (int i = 0; i < s.length(); i++)
        if (s0.find(s[i]) != -1) cnt[mp1[s[i]]]++;

    bool flag = true;
    while (flag) {
        flag = false;
        for (int i = 0; i < 6; i++)
            if (cnt[i]) {
                flag = true;
                cnt[i]--;
                cout << mp2[i];
            }
    }

    return 0;
}
