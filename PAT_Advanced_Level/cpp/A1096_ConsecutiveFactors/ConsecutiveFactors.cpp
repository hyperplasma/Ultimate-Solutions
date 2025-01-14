#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

int n;

int main() {
    cin >> n;

    vector<int> res;
    for (int i = 2; i <= n / i; i++)
        if (n % i == 0) {
            vector<int> seq;
            for (int m = n, j = i; m % j == 0; j++) {
                seq.push_back(j);
                m /= j;
            }

            if (seq.size() > res.size()) res = seq;
        }

    if (res.empty()) res.push_back(n);

    cout << res.size() << endl;
    cout << res[0];
    for (int i = 1; i < res.size(); i++) cout << '*' << res[i];

    return 0;
}
