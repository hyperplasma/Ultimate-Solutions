#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

int n, cnt = 0;
double sum = 0;

bool check(string s) {
    if (s[0] != '-' && !isdigit(s[0])) return false;
    if (s[0] == '-' && s.size() == 1) return false;

    int dotnum = 0, len = 0;
    for (int i = 1; i < s.size(); ++i) {
        if (isdigit(s[i])) {
            if (dotnum) len++;
        } else if (s[i] == '.') {
            dotnum++;
            if (dotnum > 1) return false;
        } else return false;
    }

    if (len > 2) return false;

    double a = stod(s);
    if (a < -1000 || a > 1000) return false;
    return true;
}

int main() {
    scanf("%d", &n);

    string s;
    while (n--) {
        cin >> s;

        if (check(s)) {
            sum += stod(s);
            cnt++;
        } else printf("ERROR: %s is not a legal number\n", s.c_str());
    }

    if (!cnt) printf("The average of 0 numbers is Undefined\n");
    else if (cnt == 1) printf("The average of 1 number is %.2f\n", sum);
    else printf("The average of %d numbers is %.2f\n", cnt, sum * 1.0 / cnt);

    return 0;
}
