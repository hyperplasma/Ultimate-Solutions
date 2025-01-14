#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int INF = 0x3f3f3f3f;

int n, k, S;    // 总人数、等待、Start
unordered_set <string> st;
bool flag = false;

int main() {
    scanf("%d%d%d", &n, &k, &S);

    string s;
    int cnt = INF;
    for (int i = 1; i <= n; ++i) {
        cin >> s;

        if (i == S) {
            cout << s << endl;
            flag = true;
            st.insert(s);
            cnt = 0;
            continue;
        }

        if (!st.count(s)) cnt++;
        if (cnt == k) {
            cout << s << endl;
            st.insert(s);
            cnt = 0;
        }
    }

    if (!flag) printf("Keep going...\n");

    return 0;
}
