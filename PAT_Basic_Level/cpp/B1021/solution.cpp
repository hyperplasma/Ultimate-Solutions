#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAXN = 1010;

string n;
int cnt[MAXN];

int main() {
    cin >> n;
    for (int i = 0; i < n.length(); i++) cnt[n[i] - '0']++;

    for (int i = 0; i < MAXN; i++)
        if (cnt[i]) printf("%d:%d\n", i, cnt[i]);

    return 0;
}
