#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <vector>

using namespace std;

const int N = 10010;

int p, m, n;

struct Student {
    string id;
    int Gp;
    int Gmid, Gfinal;
    double Gtotal;
    bool has_Gmid, has_Gfinal;

    bool operator<(const Student &t) const {
        if ((int) Gtotal != (int) t.Gtotal) return (int) Gtotal > (int) t.Gtotal;
        else return id < t.id;
    }
};

unordered_map <string, Student> mp;
vector <Student> v;

int main() {
    scanf("%d%d%d", &p, &m, &n);

    string id;
    int score;
    for (int i = 0; i < p; ++i) {
        cin >> id >> score;
        mp[id].id = id;
        mp[id].Gp = score;
    }
    for (int i = 0; i < m; ++i) {
        cin >> id >> score;
        mp[id].id = id;
        mp[id].Gmid = score;
        mp[id].has_Gmid = true;
    }
    for (int i = 0; i < n; ++i) {
        cin >> id >> score;
        mp[id].id = id;
        mp[id].Gfinal = score;
        mp[id].has_Gfinal = true;
    }

    for (auto &it: mp) {
        auto &stu = it.second;
        if (stu.Gp >= 200) {
            if (stu.Gmid > stu.Gfinal) stu.Gtotal = stu.Gmid * 0.4 + stu.Gfinal * 0.6 + 0.5;
            else stu.Gtotal = stu.Gfinal;

            if (!stu.has_Gmid) stu.Gmid = -1;
            if (!stu.has_Gfinal) stu.Gfinal = -1;

            if (stu.Gtotal >= 60) v.push_back(stu);
        }
    }

    sort(v.begin(), v.end());
    for (auto &i: v)
        printf("%s %d %d %d %d\n", i.id.c_str(), i.Gp, i.Gmid, i.Gfinal, (int) i.Gtotal);

    return 0;
}
