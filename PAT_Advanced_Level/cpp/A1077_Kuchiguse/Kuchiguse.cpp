#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;

int n;
string s[N];

int main() {
    cin >> n;
    getchar();
    for (int i = 0; i < n; ++i)
        getline(cin, s[i]);

    for (int k = s[0].size(); k > 0; --k) {    // k: len of suffix
        bool success = true;
        string suffix = s[0].substr(s[0].size() - k);
        for (int i = 1; i < n; ++i)
            if (s[i].size() < k || s[i].substr(s[i].size() - k) != suffix) {
                success = false;
                break;
            }

        if (success) {
            cout << suffix << endl;
            return 0;
        }
    }

    cout << "nai" << endl;
    return 0;
}
