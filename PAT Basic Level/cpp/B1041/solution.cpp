#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAXN = 1010;

int n, m;
struct Student {
    string id;
    int exam_pos;
} stu[MAXN];    // index = test_pos

int main() {
    scanf("%d", &n);
    string id;
    for (int i = 0; i < n; ++i) {
        int test_pos, exam_pos;
        cin >> id >> test_pos >> exam_pos;
        stu[test_pos] = {id, exam_pos};
    }

    scanf("%d", &m);
    while (m--) {
        int test_pos;
        scanf("%d", &test_pos);
        cout << stu[test_pos].id << " " << stu[test_pos].exam_pos << endl;
    }

    return 0;
}
