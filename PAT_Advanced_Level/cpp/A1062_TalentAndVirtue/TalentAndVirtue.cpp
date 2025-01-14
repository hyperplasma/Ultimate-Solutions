#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 100010;

int n, L, H;        // L:最低标准 H:划分线
struct Person {
    int id, virtue, talent, total;        // virtur：德，talent：才

    bool operator<(const Person &t) const {
        if (total != t.total) return total > t.total;
        else if (virtue != t.virtue) return virtue > t.virtue;
        else return id < t.id;
    }
};

vector <Person> level[4]; // 0：全过线，1：才不过德过，2：都不过线但才胜德，3：else

int main() {
    scanf("%d%d%d", &n, &L, &H);
    for (int i = 0; i < n; ++i) {
        Person p;
        scanf("%d%d%d", &p.id, &p.virtue, &p.talent);
        p.total = p.virtue + p.talent;

        if (p.virtue >= L && p.talent >= L) {
            if (p.virtue >= H && p.talent >= H)
                level[0].push_back(p);
            else if (p.virtue >= H && p.talent < H)
                level[1].push_back(p);
            else if (p.virtue < H && p.talent < H && p.virtue >= p.talent)
                level[2].push_back(p);
            else
                level[3].push_back(p);
        }
    }

    int num = 0;
    for (int i = 0; i < 4; ++i) {
        num += level[i].size();
        sort(level[i].begin(), level[i].end());
    }

    printf("%d\n", num);
    for (int i = 0; i < 4; ++i)
        for (auto &p: level[i])
            printf("%08d %d %d\n", p.id, p.virtue, p.talent);

    return 0;
}
