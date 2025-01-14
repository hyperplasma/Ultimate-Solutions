#include <iostream>
#include <cstring>

using namespace std;

const int N = 1010;

int n;
bool col[N], diag[N * 2], rdiag[N * 2];        // diag=y-x, rdiag=y+x

int main() {
    cin >> n;
    while (n--) {
        memset(col, false, sizeof col);
        memset(diag, false, sizeof diag);
        memset(rdiag, false, sizeof rdiag);

        int m;
        cin >> m;

        bool flag = true;
        for (int x = 1; x <= m; ++x) {
            int y;
            cin >> y;

            if (col[y] || diag[y - x + m] || rdiag[y + x])
                flag = false;
            col[y] = diag[y - x + m] = rdiag[y + x] = true;
        }

        if (flag) cout << "YES" << endl;
        else cout << "NO" << endl;
    }

    return 0;
}
