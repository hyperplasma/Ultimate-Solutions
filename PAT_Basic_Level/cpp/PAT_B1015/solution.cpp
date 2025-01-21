#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int MAXN = 1e5 + 10;

int n, L, H;    // L: lowest, H: preferred
struct Student {
    string id;
    int de, cai, sum;
};
vector <Student> stu[4];

bool cmp(Student &a, Student &b) {
    if (a.sum != b.sum) return a.sum > b.sum;
    if (a.de != b.de) return a.de > b.de;
    return a.id < b.id;
}

int main() {
    scanf("%d%d%d", &n, &L, &H);

    string id;
    for (int i = 0; i < n; ++i) {
        int de, cai;
        cin >> id >> de >> cai;
        Student a = {id, de, cai, de + cai};

        if (de < L || cai < L) continue;

        if (de >= H && cai >= H) stu[0].push_back(a);
        else if (cai < H && de >= H) stu[1].push_back(a);
        else if (cai < H && de < H && de >= cai) stu[2].push_back(a);
        else stu[3].push_back(a);
    }

    int cnt = 0;
    for (int i = 0; i < 4; ++i) {
        sort(stu[i].begin(), stu[i].end(), cmp);
        cnt += stu[i].size();
    }

    printf("%d\n", cnt);
    for (int i = 0; i < 4; ++i)
        for (auto &item: stu[i])
            cout << item.id << " " << item.de << " " << item.cai << endl;

    return 0;
}
