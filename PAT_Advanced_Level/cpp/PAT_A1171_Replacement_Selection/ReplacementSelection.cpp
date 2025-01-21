#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

int n, m;
priority_queue<int, vector<int>, greater<int> > mem, tmp;

int main() {
    scanf("%d%d", &n, &m);

    int x, last;
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &x);

        if (i <= m) {
            mem.push(x);

            if (i == m) {
                last = mem.top();
                mem.pop();
                printf("%d", last);
            }
        } else {
            if (x < last) tmp.push(x);
            else mem.push(x);

            if (!mem.empty()) {
                last = mem.top();
                mem.pop();
                printf(" ");
                printf("%d", last);
            } else {
                swap(mem, tmp);
                printf("\n");

                last = mem.top();
                mem.pop();
                printf("%d", last);
            }
        }
    }

    while (!mem.empty()) {
        printf(" ");
        printf("%d", mem.top());
        mem.pop();
    }


    if (!tmp.empty()) {
        swap(mem, tmp);
        bool is_first = true;
        printf("\n");

        while (!mem.empty()) {
            if (is_first) is_first = false;
            else printf(" ");
            printf("%d", mem.top());
            mem.pop();
        }
        printf("\n");
    }

    return 0;
}
