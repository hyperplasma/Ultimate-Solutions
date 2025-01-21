#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <vector>

using namespace std;

int n, k;
unordered_map <string, vector<int>> students;

int main() {
    cin >> n >> k;

    string name;
    while (k--) {
        int id, m;
        cin >> id >> m;
        while (m--) {
            cin >> name;
            students[name].push_back(id);
        }
    }

    while (n--) {
        cin >> name;

        auto &ls = students[name];
        cout << name << ' ' << ls.size();
        sort(ls.begin(), ls.end());

        for (auto l: ls) cout << ' ' << l;
        cout << endl;
    }

    return 0;
}
