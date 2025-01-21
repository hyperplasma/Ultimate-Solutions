#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

const int N = 10010;

int n;
int seq[N];
double sum;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &seq[i]);
    sort(seq, seq + n);

    sum = seq[0];
    for (int i = 1; i < n; ++i)
        sum = (sum + seq[i]) / 2;

    printf("%d\n", (int) floor(sum));

    return 0;
}
