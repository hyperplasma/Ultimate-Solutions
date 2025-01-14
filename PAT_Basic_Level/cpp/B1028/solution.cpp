#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

int n;
struct Citizen {
    string name;
    int y, m, d;
};
vector <Citizen> v;

bool cmp(Citizen a, Citizen b) {
    if (a.y != b.y) return a.y < b.y;
    if (a.m != b.m) return a.m < b.m;
    return a.d < b.d;
}

int main() {
    scanf("%d", &n);

    string name;
    for (int i = 0; i < n; i++) {
        int y, m, d;
        cin >> name;
        scanf("%d/%d/%d", &y, &m, &d);

        if (y < 1814 || (y == 1814 && m < 9) || (y == 1814 && m == 9 && d < 6)) continue;
        if (y > 2014 || (y == 2014 && m > 9) || (y == 2014 && m == 9 && d > 6)) continue;

        v.push_back({name, y, m, d});
    }

    if (v.empty()) printf("0");
    else {
        sort(v.begin(), v.end(), cmp);
        printf("%d %s %s", v.size(), v.front().name.c_str(), v.back().name.c_str());
    }

    return 0;
}
