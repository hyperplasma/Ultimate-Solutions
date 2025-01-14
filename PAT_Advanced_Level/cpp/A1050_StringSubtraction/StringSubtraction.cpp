#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int MAXN = 10010;

string s1, s2;
unordered_set<char> st;

int main() {
    getline(cin, s1);
    getline(cin, s2);

    for (int i = 0; i < s2.size(); i++) st.insert(s2[i]);

    string res;
    for (int i = 0; i < s1.size(); i++) {
        if (!st.count(s1[i])) res += s1[i];
    }

    cout << res << endl;
    return 0;
}
