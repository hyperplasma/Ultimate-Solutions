#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 210;

int n, Q;

struct Person {
    string name;
    int age, worth;

    bool operator<(const Person &t) const {
        if (worth != t.worth) return worth > t.worth;
        else if (age != t.age) return age < t.age;
        else return name < t.name;
    }
};

vector <Person> ages[N];
int cnt[N];

int main() {
    scanf("%d%d", &n, &Q);

    char name[10];
    for (int i = 0; i < n; ++i) {
        int age, worth;
        scanf("%s%d%d", name, &age, &worth);
        ages[age].push_back({name, age, worth});
    }

    for (int i = 0; i < N; ++i) sort(ages[i].begin(), ages[i].end());

    for (int idx = 1; idx <= Q; ++idx) {
        int m, amin, amax;
        scanf("%d%d%d", &m, &amin, &amax);
        printf("Case #%d:\n", idx);

        memset(cnt, 0, sizeof cnt);
        bool exists = false;

        while (m--) {
            int t = -1;
            for (int i = amin; i <= amax; ++i)
                if (cnt[i] < ages[i].size()) {
                    if (t == -1 || ages[i][cnt[i]] < ages[t][cnt[t]])
                        t = i;
                }

            if (t == -1) break;
            auto &p = ages[t][cnt[t]++];

            printf("%s %d %d\n", p.name.c_str(), p.age, p.worth);
            exists = true;
        }

        if (!exists) printf("None\n");
    }

    return 0;
};
