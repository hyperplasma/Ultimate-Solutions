#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100;

string s, words[N];
int len;

int main() {
    getline(cin, s);
    for (int i = 0; i < s.size(); i++) {
        if (s[i] != ' ') words[len] += s[i];
        else len++;
    }

    for (int i = len; i >= 0; i--) {
        cout << words[i];
        if (i > 0) cout << " ";
    }

    return 0;
}
