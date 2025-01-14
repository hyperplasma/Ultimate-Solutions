#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;

int n;

struct Person {
    string name, id;
    int grade;

    bool operator<(const Person &t) const {
        return grade > t.grade;
    }
} p[N];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) cin >> p[i].name >> p[i].id >> p[i].grade;

    int g1, g2;
    cin >> g1 >> g2;

    int m = 0;
    for (int i = 0; i < n; i++)
        if (p[i].grade >= g1 && p[i].grade <= g2)
            p[m++] = p[i];

    if (!m) puts("NONE");
    else {
        sort(p, p + m);
        for (int i = 0; i < m; i++)
            cout << p[i].name << ' ' << p[i].id << endl;
    }

    return 0;
}
