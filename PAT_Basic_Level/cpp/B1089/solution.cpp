#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int n, id[N], judge[N];

void search(int &liewolf_cnt, int &lieppl_cnt) {
    for (int i = 1; i <= n; i++) {
        int flag = 0;
        if (judge[i] < 0) flag = -1;

        if (id[abs(judge[i])] != flag) {
            if (id[i] == -1) liewolf_cnt++;
            else lieppl_cnt++;
        }
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d", &judge[i]);

    int flag = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            int liewolf_cnt = 0, lieppl_cnt = 0;
            memset(id, 0, sizeof id);

            id[i] = id[j] = -1;
            search(liewolf_cnt, lieppl_cnt);
            if (liewolf_cnt == 1 && lieppl_cnt == 1) {
                flag = 1;
                printf("%d %d", i, j);
                break;
            }
        }
        if (flag == 1) break;
    }

    if (flag == 0) printf("No Solution");

    return 0;
}
