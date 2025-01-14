#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string a, da, pa;
string b, db, pb;

int main() {
    cin >> a >> da >> b >> db;

    int cnt_a = 0;
    for (int i = 0; i < a.length(); i++)
        if (a[i] == da[0]) {
            pa += da[0];
            cnt_a++;
        }

    int cnt_b = 0;
    for (int i = 0; i < b.length(); i++)
        if (b[i] == db[0]) {
            pb += db[0];
            cnt_b++;
        }

    int n_a = 0, n_b = 0;
    if (cnt_a) n_a = stoi(pa);
    if (cnt_b) n_b = stoi(pb);
    printf("%d", n_a + n_b);

    return 0;
}
