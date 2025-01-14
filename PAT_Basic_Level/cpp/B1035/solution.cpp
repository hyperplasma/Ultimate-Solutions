#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n;
vector<int> a(105, 0), b(105, 0), c;
bool flag;

void insert_sort() {
    int i = 1;
    for (; i < n; i++) {
        for (int j = i; j > 0 && a[j - 1] > a[j]; j--) swap(a[j - 1], a[j]);
        if (a == b) {
            flag = true;
            break;
        }
    }
    if (flag) {
        i++;
        if (i < n) for (int j = i; j && b[j - 1] > b[j]; j--) swap(b[j - 1], b[j]);
    }
}

void merge_sort() {
    puts("Merge Sort");
    int i = 2;
    for (; i <= n; i *= 2) {
        for (int j = 0; j + i <= n; j += i) sort(c.begin() + j, c.begin() + j + i);
        if (n % i) sort(c.begin() + n / i * i, c.begin() + n);
        if (c == b) break;
    }
    i = i * 2;
    for (int j = 0; j + i <= n; j += i) sort(b.begin() + j, b.begin() + j + i);
    if (n % i) sort(b.begin() + n / i * i, b.begin() + n);
}

int main(void) {
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < n; i++) cin >> b[i];

    c = a;
    insert_sort();
    if (!flag) merge_sort();
    else puts("Insertion Sort");
    for (int i = 0; i < n; i++) {
        cout << b[i];
        if (i != n - 1) cout << " ";
    }

    return 0;
}
