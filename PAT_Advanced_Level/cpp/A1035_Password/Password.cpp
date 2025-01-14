#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int MAXN = 10010, INF = 1e7 + 10;

int n;
vector <pair<string, string>> accounts;

bool modify(string &pswd) {
    string res;

    for (int i = 0; i < pswd.size(); ++i) {
        if (pswd[i] == '1') res += '@';
        else if (pswd[i] == '0') res += '%';
        else if (pswd[i] == 'l') res += 'L';
        else if (pswd[i] == 'O') res += 'o';
        else res += pswd[i];
    }

    if (pswd == res) return false;
    pswd = res;
    return true;
}

int main() {
    scanf("%d", &n);

    string id, pswd;
    for (int i = 0; i < n; ++i) {
        cin >> id >> pswd;
        if (modify(pswd)) accounts.push_back({id, pswd});
    }

    if (accounts.empty()) {
        if (n == 1) printf("There is 1 account and no account is modified\n");
        else printf("There are %d accounts and no account is modified\n", n);
    } else {
        printf("%d\n", accounts.size());
        for (auto it: accounts)
            cout << it.first << " " << it.second << endl;
    }
    return 0;
}
