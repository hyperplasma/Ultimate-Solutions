#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string day[8] = {"", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

string a, b, c, d;

int main() {
    cin >> a >> b >> c >> d;

    int flag = 0;
    for (int i = 0;; ++i)
        if (a[i] == b[i]) {
            if (flag == 0 && 'A' <= a[i] && a[i] <= 'G') {
                cout << day[a[i] - 'A' + 1];
                flag = 1;
            } else if (flag == 1) {
                if ('0' <= a[i] && a[i] <= '9') {
                    printf(" %02d:", a[i] - '0');
                    break;
                } else if ('A' <= a[i] && a[i] <= 'N') {
                    printf(" %02d:", 10 + a[i] - 'A');
                    break;
                }
            }
        }

    for (int i = 0;; ++i)
        if (c[i] == d[i] && isalpha(c[i])) {
            printf("%02d", i);
            break;
        }
    printf("\n");

    return 0;
}
