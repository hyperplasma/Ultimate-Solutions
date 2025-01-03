#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

string s1, s2;
unordered_set<char> st;

int main() {
    getline(cin, s1);
    getline(cin, s2);

    int i = 0, j = 0;
    while (i < s1.size() && j < s2.size()) {
        if (s1[i] != s2[j] && s1[i] != '_') {
            if ('a' <= s1[i] && s1[i] <= 'z') s1[i] -= 32;
            if (!st.count(s1[i])) {
                st.insert(s1[i]);
                printf("%c", s1[i]);
            }
            i++;
        } else if (s1[i] != s2[j] && s1[i] == '_') {
            if (!st.count(s1[i])) {
                st.insert(s1[i]);
                printf("%c", s1[i]);
            }
            i++;
        } else {
            i++;
            j++;
        }
    }

    while (i < s1.size()) {
        if (s1[i] != '_') {
            if ('a' <= s1[i] && s1[i] <= 'z') s1[i] -= 32;
            if (!st.count(s1[i])) {
                st.insert(s1[i]);
                printf("%c", s1[i]);
            }
        }
        i++;
    }
    return 0;
}
