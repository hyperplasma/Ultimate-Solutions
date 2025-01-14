#include <iostream>
#include <cstring>
#include <algorithm>
#include <stack>

using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    int c = a + b;
    if (c < 0) cout << "-";
    string str = to_string(abs(c));

    stack<char> stk;
    for (int i = (int) str.size() - 1, cnt = 0; i >= 0; i--) {
        if (cnt == 3) {
            stk.push(',');
            cnt = 0;
        }
        stk.push(str[i]);
        cnt++;
    }

    while (!stk.empty()) {
        cout << stk.top();
        stk.pop();
    }

    return 0;
}
