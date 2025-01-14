#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 10010;

int n, m;
vector<int> c_p, c_n, p_p, p_n;

int main() {
    cin >> n;
    while (n--) {
        int x;
        cin >> x;
        if (x > 0) c_p.push_back(x);
        else if (x < 0) c_n.push_back(x);
    }

    cin >> m;
    while (m--) {
        int x;
        cin >> x;
        if (x > 0) p_p.push_back(x);
        else if (x < 0) p_n.push_back(x);
    }

    sort(c_p.begin(), c_p.end(), greater<int>());
    sort(c_n.begin(), c_n.end());
    sort(p_p.begin(), p_p.end(), greater<int>());
    sort(p_n.begin(), p_n.end());

    int sum = 0;
    for (int i = 0; i < c_p.size() && i < p_p.size(); ++i)
        sum += c_p[i] * p_p[i];
    for (int i = 0; i < c_n.size() && i < p_n.size(); ++i)
        sum += c_n[i] * p_n[i];
    cout << sum << endl;

    return 0;
}
