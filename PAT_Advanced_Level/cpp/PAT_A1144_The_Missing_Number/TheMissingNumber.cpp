#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int N = 10010;

int n;
unordered_set<int> s;

int main() {
    scanf("%d", &n);
    while (n--) {
        int x;
        scanf("%d", &x);
        if (x > 0) s.insert(x);
    }

    for (int x = 1;; ++x)
        if (!s.count(x)) {
            printf("%d", x);
            break;
        }

    return 0;
};
