#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 1e5 + 10, INF = 0x3f3f3f3f;

int n;
int a[N], b[N];
vector<int> v;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
        b[i] = a[i];
    }

    sort(b, b + n);

    int lmax = -INF;
    for (int i = 0; i < n; i++) {
        if (a[i] == b[i] && a[i] >= lmax) v.push_back(a[i]);
        lmax = max(lmax, a[i]);
    }

    printf("%d\n", v.size());
    for (int i = 0; i < v.size(); i++) {
        if (i > 0) printf(" ");
        printf("%d", v[i]);
    }
    printf("\n");

    return 0;
}







