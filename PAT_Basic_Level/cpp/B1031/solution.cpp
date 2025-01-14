#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

int w[17] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
char m[11] = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

int n;
string s;
vector <string> res;

int main(void) {
    scanf("%d", &n);
    while (n--) {
        cin >> s;

        int z = 0;
        bool flag = true;
        for (int i = 0; i < s.length() - 1; i++)
            if (isdigit(s[i])) z += w[i] * (s[i] - '0');
            else {
                flag = false;
                break;
            }

        z %= 11;
        if (m[z] != s[17]) flag = false;
        if (!flag) res.push_back(s);
    }

    if (res.empty()) puts("All passed");
    else {
        for (int i = 0; i < res.size(); i++)
            cout << res[i] << endl;
    }

    return 0;
}
