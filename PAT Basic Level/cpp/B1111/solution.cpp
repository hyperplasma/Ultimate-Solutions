#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

int n;
unordered_map <string, string> mp;
string yy, mm, dd;

bool check(string s) {
    for (int i = 0; i < s.size(); ++i)
        if (s[i] != s[s.size() - 1 - i])
            return false;
    return true;
}

void init() {
    mp["Jan"] = "01";
    mp["Feb"] = "02";
    mp["Mar"] = "03";
    mp["Apr"] = "04";
    mp["May"] = "05";
    mp["Jun"] = "06";
    mp["Jul"] = "07";
    mp["Aug"] = "08";
    mp["Sep"] = "09";
    mp["Oct"] = "10";
    mp["Nov"] = "11";
    mp["Dec"] = "12";
}

int main() {
    scanf("%d", &n);

    init();
    while (n--) {
        string month;
        cin >> month;
        int day, year;
        scanf("%d, %d", &day, &year);

        yy = to_string(year);
        while (yy.size() < 4) yy = "0" + yy;
        mm = mp[month];
        dd = to_string(day);
        if (dd.size() < 2) dd = "0" + dd;

        string res = yy + mm + dd;
        if (check(res)) printf("Y ");
        else printf("N ");
        cout << res << endl;
    }

    return 0;
}
