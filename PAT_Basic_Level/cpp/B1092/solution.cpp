#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAXN = 1010;

int n, m;
struct Cake {
    int id, sale;
} cake[MAXN];

bool cmp(Cake a, Cake b) {
    if (a.sale != b.sale) return a.sale > b.sale;
    return a.id < b.id;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        for (int id = 1; id <= n; ++id) {
            int sale;
            scanf("%d", &sale);
            cake[id].id = id;
            cake[id].sale += sale;
        }
    }

    sort(cake + 1, cake + 1 + n, cmp);
    printf("%d\n%d", cake[1].sale, cake[1].id);
    for (int i = 2; i <= n; ++i) {
        if (cake[i].sale == cake[i - 1].sale) printf(" %d", cake[i].id);
        else break;
    }

    return 0;
}
