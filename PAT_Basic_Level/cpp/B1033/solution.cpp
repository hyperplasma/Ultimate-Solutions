#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

string t, s;
unordered_set<char> st;

int main() {
    getline(cin, t);
    for (int i = 0; i < t.length(); i++) {
        st.insert(toupper(t[i]));
        st.insert(tolower(t[i]));
    }

    getline(cin, s);
    for (int i = 0; i < s.length(); i++) {
        if (st.count(s[i]) || (isupper(s[i]) && st.count('+'))) continue;
        else printf("%c", s[i]);
    }

    return 0;
}
