#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>

using namespace std;

int n;
struct Student {
    string name, id;
    int score;
};
vector <Student> stu;

bool cmp1(Student a, Student b) {
    return a.score > b.score;
}

bool cmp2(Student a, Student b) {
    return a.score < b.score;
}

int main() {
    scanf("%d", &n);

    string tmp_name, tmp_id;
    while (n--) {
        int score;
        cin >> tmp_name >> tmp_id >> score;
        stu.push_back({tmp_name, tmp_id, score});
    }

    sort(stu.begin(), stu.end(), cmp1);
    cout << stu[0].name << " " << stu[0].id << endl;

    sort(stu.begin(), stu.end(), cmp2);
    cout << stu[0].name << " " << stu[0].id << endl;
}
