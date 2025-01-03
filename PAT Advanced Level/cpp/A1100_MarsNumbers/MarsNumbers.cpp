#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

char low[13][5] = {
        "tret", "jan", "feb", "mar", "apr", "may",
        "jun", "jly", "aug", "sep", "oct", "nov", "dec"
};
char high[13][5] = {
        "", "tam", "hel", "maa", "huh", "tou", "kes",
        "hei", "elo", "syy", "lok", "mer", "jou"
};

int n;
string s;
unordered_map<string, int> mp;

int main() {
    scanf("%d", &n);
    getchar();
    for (int i = 0; i < 13; i++) {
        string temp;
        temp = low[i];
        mp[temp] = i;
        temp = high[i];
        mp[temp] = 13 * i;
    }

    for (int i = 0; i < n; i++) {
        getline(cin, s);
        int len = s.length();
        if (isdigit(s[0])) {
            int digit = stoi(s);
            int n1 = digit / 13, n2 = digit % 13;
            if (n1 > 0) {
                printf("%s", high[n1]);
                if (n2 > 0) printf(" %s", low[n2]);
            } else printf("%s", low[n2]);

            printf("\n");
        } else {
            int pos = -1;
            for (int j = 0; j < len; j++)
                if (s[j] == ' ') {
                    pos = j;
                    break;
                }

            if (pos == -1) printf("%d", mp[s]);
            else printf("%d", mp[s.substr(0, pos)] + mp[s.substr(pos + 1, len - 1 - pos)]);
            printf("\n");
        }
    }
    return 0;
}
