#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;

int n;
int a[N], b[N];
bool is_Insert = true;

bool check() {
    for (int i = 0; i < n; ++i)
        if (a[i] != b[i])
            return false;
    return true;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) cin >> a[i];
    for (int i = 0; i < n; ++i) cin >> b[i];

    int k = 0;
    while (k < n - 1 && b[k] <= b[k + 1]) k++;

    for (int i = k + 1; i < n; ++i)
        if (a[i] != b[i]) {
            is_Insert = false;
            break;
        }

    if (is_Insert) {
        cout << "Insertion Sort" << endl;

        sort(b, b + k + 2);
        for (int i = 0; i < n; ++i) {
            if (i > 0) cout << " ";
            cout << b[i];
        }
    } else {
        cout << "Merge Sort" << endl;

        int k = 1;
        while (true) {
            bool match = check();

            int len = pow(2, k);
            for (int i = 0; i < n; i += len)
                sort(a + i, a + min(n, i + len));

            if (match) break;
            k++;
        }

        for (int i = 0; i < n; ++i) {
            if (i > 0) cout << " ";
            cout << a[i];
        }
    }

    return 0;
}
