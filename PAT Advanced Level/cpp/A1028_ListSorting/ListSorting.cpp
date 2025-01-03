#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n;
struct Row {
    string id, name;
    int grade;
} rows[N];

bool cmp1(Row a, Row b) {
    return a.id < b.id;
}

bool cmp2(Row a, Row b) {
    if (a.name != b.name) return a.name < b.name;
    return a.id < b.id;
}

bool cmp3(Row a, Row b) {
    if (a.grade != b.grade) return a.grade < b.grade;
    return a.id < b.id;
}

int main() {
    int c;
    scanf("%d%d", &n, &c);
    char id[10], name[10];
    for (int i = 0; i < n; i++) {
        int grade;
        scanf("%s%s%d", id, name, &grade);
        rows[i] = {id, name, grade};
    }

    if (c == 1) sort(rows, rows + n, cmp1);
    else if (c == 2) sort(rows, rows + n, cmp2);
    else sort(rows, rows + n, cmp3);

    for (int i = 0; i < n; i++)
        printf("%s %s %d\n", rows[i].id.c_str(), rows[i].name.c_str(), rows[i].grade);

    return 0;
}
