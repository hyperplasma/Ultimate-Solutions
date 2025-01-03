#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string a, b;
bool st[210];

int main() {
    cin >> a >> b;

    b += '#';
    for (int i = 0, j = 0; i < a.size(); i++) {
        char x = toupper(a[i]), y = toupper(b[j]);
        if (x == y) j++;
        else if (!st[x]) {
            cout << x;
            st[x] = true;
        }
    }

    return 0;
}
