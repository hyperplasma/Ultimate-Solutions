#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int n;
vector<int> v;

void find_factors(int x) {
    for (int i = 1; i <= x; i++)
        if (x % i == 0) v.push_back(i);
}

bool judge(int x) {
    v.clear();
    find_factors(x);
    for (int i = 0; i < (int) v.size() - 3; i++)
        for (int j = i + 1; j < v.size(); j++)
            for (int m = j + 1; m < v.size(); m++)
                for (int n = m + 1; n < v.size(); n++) {
                    int sum = v[i] + v[j] + v[m] + v[n];
                    if (sum % x == 0)
                        return true;
                }

    return false;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        printf("%s\n", judge(x) ? "Yes" : "No");
    }
    return 0;
}
