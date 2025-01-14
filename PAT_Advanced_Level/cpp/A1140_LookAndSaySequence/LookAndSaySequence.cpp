#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n;
string a;

int main() {
    cin >> a >> n;
    for (int i = 2; i <= n; i++) {
        string temp;
        int k = 0;
        for (int j = 0; j < a.length(); j++) {
            k++;
            if (a[j] != a[j + 1]) {
                temp += a[j] + to_string(k);
                k = 0;
            }
        }
        a = temp;
    }
    cout << a;
    return 0;
}
