#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int cnt[10];

int main() {
    for (int i = 0; i < 10; ++i)
        scanf("%d", &cnt[i]);

    for (int i = 1; i < 10; ++i)
        if (cnt[i]) {
            printf("%d", i);
            cnt[i]--;
            break;
        }

    for (int i = 0; i < 10; ++i)
        while (cnt[i]--)
            printf("%d", i);

    return 0;
}
