#include <iostream>
#include <cstring>
#include <unordered_set>
#include <vector>

using namespace std;

string s;
string subs;
unordered_set<char> st;
vector <string> v;

int main() {
    cin >> s >> subs;
    for (int i = 0; i < subs.size(); ++i) st.insert(subs[i]);

    for (int i = 0; i < s.size(); ++i) {
        int j = i, cnt = 0;
        while (j < s.size() && cnt < subs.size()) {
            if (s[j] == subs[cnt]) cnt++;
            j++;
        }

        if (cnt < subs.size()) continue;
        v.push_back(s.substr(i, j - i));
    }

    // for (int i = 0; i < v.size(); ++i)
    // cout << i << ": " << v[i] << endl;

    int min_len = s.size() + 1, min_idx = -1;
    for (int i = 0; i < v.size(); ++i)
        if (v[i].size() < min_len) {
            min_len = v[i].size();
            min_idx = i;
        }
    cout << v[min_idx] << endl;

    return 0;
}