#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010, INF = 0x3f3f3f3f;

int n;
int school[N];

int main() {
    scanf("%d", &n);

    int max_score = -INF, max_idx = 0;
    for (int i = 0; i < n; i++) {
        int idx, score;
        scanf("%d %d", &idx, &score);
        school[idx] += score;
        if (school[idx] > max_score) {
            max_score = school[idx];
            max_idx = idx;
        }
    }

    printf("%d %d\n", max_idx, max_score);

    return 0;
}
