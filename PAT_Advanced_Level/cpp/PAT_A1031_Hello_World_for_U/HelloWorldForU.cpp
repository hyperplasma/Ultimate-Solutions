#include <iostream>
#include <cstring>

using namespace std;

const int N = 90;

char g[N][N];

int main() {
    memset(g, ' ', sizeof(g));
    string s;
    cin >> s;

    int n = s.size();
    int n1 = (n + 2) / 3;
    int n2 = n + 2 - 2 * n1;

    int k = 0;
    for (int i = 1; i <= n1; ++i) g[i][1] = s[k++];
    for (int i = 2; i <= n2; ++i) g[n1][i] = s[k++];
    for (int i = n1 - 1; i >= 1; --i) g[i][n2] = s[k++];

    for (int i = 1; i <= n1; ++i) {
        for (int j = 1; j <= n2; ++j)
            cout << g[i][j];
        cout << endl;
    }

    return 0;
}
