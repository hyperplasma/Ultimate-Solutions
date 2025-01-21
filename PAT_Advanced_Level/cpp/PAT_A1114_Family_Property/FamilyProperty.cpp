#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 10010;

int n;
int p[N];

struct Node {
    int id, dad, mom;
    int num, cnt, area;
    vector<int> childs;

    Node() : num(1) {}

    bool operator<(const Node &t) const {
        if (area * t.num != t.area * num) return area * t.num > t.area * num;
        else return id < t.id;
    }
} nodes[N];

bool flag[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

void Union(int a, int b) {
    int pa = find(a), pb = find(b);
    if (pa != pb) {
        if (pa > pb) swap(pa, pb);    // 固定 pa < pb
        p[pb] = pa;
        nodes[pa].num += nodes[pb].num;
        nodes[pa].cnt += nodes[pb].cnt;
        nodes[pa].area += nodes[pb].area;
    }
}

int main() {
    for (int i = 0; i < N; ++i) {
        p[i] = i;
        nodes[i].id = i;
    }

    scanf("%d", &n);
    vector<int> ppl;
    for (int i = 0; i < n; ++i) {
        int id, cnum;
        scanf("%d", &id);
        nodes[id].id = id;
        ppl.push_back(id);

        scanf("%d%d%d", &nodes[id].dad, &nodes[id].mom, &cnum);
        while (cnum--) {
            int child;
            scanf("%d", &child);
            nodes[id].childs.push_back(child);
        }
        scanf("%d%d", &nodes[id].cnt, &nodes[id].area);
    }

    for (auto id: ppl) {    // 集中合并
        flag[id] = true;

        if (nodes[id].dad != -1) {
            flag[nodes[id].dad] = true;
            Union(id, nodes[id].dad);
        }
        if (nodes[id].mom != -1) {
            flag[nodes[id].mom] = true;
            Union(id, nodes[id].mom);
        }

        for (auto child: nodes[id].childs) {
            flag[child] = true;
            Union(id, child);
        }
    }

    vector <Node> res;
    for (int a = 0; a < N; ++a) {
        int pa = find(a);
        if (pa == a && flag[pa]) res.push_back(nodes[pa]);
    }

    sort(res.begin(), res.end());

    printf("%d\n", res.size());
    for (auto i: res)
        printf("%04d %d %.3f %.3f\n", i.id, i.num, i.cnt * 1.0 / i.num, i.area * 1.0 / i.num);

    return 0;
}
