#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string s;

int main() {
    cin >> s;

    if (s.size() == 3) {
        for (int i = 0; i < s[0] - '0'; i++) printf("B");
        for (int i = 0; i < s[1] - '0'; i++) printf("S");
        for (int i = 1; i <= s[2] - '0'; i++) printf("%d", i);
    } else if (s.size() == 2) {
        for (int i = 0; i < s[0] - '0'; i++) printf("S");
        for (int i = 1; i <= s[1] - '0'; i++) printf("%d", i);
    } else {
        for (int i = 1; i <= s[0] - '0'; i++) printf("%d", i);
    }

    return 0;
}
