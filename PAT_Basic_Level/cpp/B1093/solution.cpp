#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string s1, s2;
bool st[200];

int main() {
    getline(cin, s1);
    getline(cin, s2);

    s1 += s2;
    for (int i = 0; i < s1.size(); ++i)
        if (!st[s1[i]]) {
            printf("%c", s1[i]);
            st[s1[i]] = 1;
        }

    return 0;
}
