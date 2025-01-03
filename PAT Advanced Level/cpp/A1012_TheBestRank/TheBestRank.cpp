#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>
#include <vector>

using namespace std;

const int N = 2010;

int n, m;

struct Student {
    int id, score, r;

    bool operator<(const Student &t) const {
        if (score != t.score) return score > t.score;
        return id < t.id;
    }
};

unordered_set<int> st;
vector <Student> list[4];                // 0: A, 1: C, 2: M, 3: E
string words[5] = {"A", "C", "M", "E"};

int main() {
    scanf("%d%d", &n, &m);

    int id, scores[4];
    for (int i = 0; i < n; ++i) {
        memset(scores, 0, sizeof(scores));

        scanf("%d", &id);
        for (int j = 1; j < 4; ++j) {
            scanf("%d", &scores[j]);
            scores[0] += scores[j];
        }
        scores[0] /= 3;
        st.insert(id);

        for (int j = 0; j < 4; ++j)
            list[j].push_back({id, scores[j], 0});
    }

    for (int k = 0; k < 4; ++k) {
        sort(list[k].begin(), list[k].end());

        list[k][0].r = 1;
        for (int i = 1; i < list[k].size(); ++i) {
            if (list[k][i].score == list[k][i - 1].score)
                list[k][i].r = list[k][i - 1].r;
            else list[k][i].r = i + 1;
        }
    }

    while (m--) {
        scanf("%d", &id);
        if (!st.count(id)) {
            printf("N/A\n");
            continue;
        }

        int idx = -1, bestr = N;
        for (int k = 0; k < 4; ++k)
            for (auto stu: list[k])
                if (stu.id == id && bestr > stu.r) {
                    bestr = stu.r;
                    idx = k;
                }

        printf("%d %s\n", bestr, words[idx].c_str());
    }

    return 0;
}
