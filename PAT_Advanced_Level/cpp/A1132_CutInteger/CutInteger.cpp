#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long ll;

int main() {
    int n;
    scanf("%d", &n);

    string s;
    while (n--) {
        cin >> s;

        ll z = stoll(s);
        int len = s.size() / 2;
        ll a = stoll(s.substr(0, len)), b = stoll(s.substr(len));

        if (a * b != 0 && z % (a * b) == 0) printf("Yes\n");
        else printf("No\n");
    }

    return 0;
}
