#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 127;

string s1, s2;
int cnt1[N], cnt2[N];

int main() {
    cin >> s1 >> s2;

    for (int i = 0; i < s1.length(); i++) cnt1[s1[i]]++;
    for (int i = 0; i < s2.length(); i++) cnt2[s2[i]]++;

    bool flag = false;
    int res = 0;
    for (int i = 0; i < N; i++)
        if (cnt2[i] && cnt1[i] < cnt2[i]) {
            flag = true;
            res += cnt2[i] - cnt1[i];
        }

    if (!flag) {
        for (int i = 0; i < N; i++) {
            if (cnt2[i] && cnt1[i] >= cnt2[i]) res += cnt1[i] - cnt2[i];
            else if (!cnt2[i] && cnt1[i]) res += cnt1[i];
        }
    }

    printf("%s %d", (!flag) ? "Yes" : "No", res);

    return 0;
}
