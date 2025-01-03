#include <iostream>
#include <cstring>
#include <algorithm>
#include <set>

using namespace std;

int n;
set<int> s;

int main() {
    scanf("%d", &n);
    while (n--) {
        int x, sum = 0;
        scanf("%d", &x);

        while (x) {
            sum += x % 10;
            x /= 10;
        }
        s.insert(sum);
    }

    printf("%d\n", s.size());
    bool is_first = true;
    for (auto it: s) {
        if (is_first) is_first = false;
        else printf(" ");
        printf("%d", it);
    }
    printf("\n");

    return 0;
}
