#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n, arr[5];

void to_array(int num[], int n) {
    for (int i = 0; i < 4; i++) {
        num[i] = n % 10;
        n /= 10;
    }
}

int to_number(int num[]) {
    int n = 0;
    for (int i = 0; i < 4; i++) {
        n = n * 10 + num[i];
    }
    return n;
}

int main() {
    scanf("%d", &n);

    while (true) {
        to_array(arr, n);
        sort(arr, arr + 4, greater<int>());
        int max = to_number(arr);
        sort(arr, arr + 4);
        int min = to_number(arr);
        n = max - min;

        printf("%04d - %04d = %04d\n", max, min, n);
        if (n == 0 || n == 6174) break;
    }

    return 0;
}
