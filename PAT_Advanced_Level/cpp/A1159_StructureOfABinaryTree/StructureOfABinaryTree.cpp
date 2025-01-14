#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

const int N = 1010;

int n, m;
int l[N], r[N], w[N];
int p[N], depth[N];
int post[N], in[N], inpos[N];
bool is_full = true;

int build(int inL, int inR, int postL, int postR, int d) {
    // if (inL > inR) return 1009;    // 须为严格大于号，或直接不特判

    int root = post[postR];
    depth[root] = d;

    int k = inpos[root];
    int ccnt = 0;
    if (inL < k) {
        l[root] = build(inL, k - 1, postL, postL + (k - 1 - inL), d + 1);
        p[l[root]] = root;
        ccnt++;
    }
    if (k < inR) {
        r[root] = build(k + 1, inR, postL + (k - 1 - inL) + 1, postR - 1, d + 1);
        p[r[root]] = root;
        ccnt++;
    }
    if (ccnt == 1) is_full = false;

    return root;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &post[i]);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &in[i]);
        inpos[in[i]] = i;
    }

    int root = build(0, n - 1, 0, n - 1, 0);
    p[root] = -1;

    scanf("%d", &m);
    getchar();
    string s, tmp;
    while (m--) {
        getline(cin, s);
        bool flag = false;
        tmp.clear();

        if (s[s.size() - 1] == 't') {    // root
            for (int i = 0; isdigit(s[i]); ++i) tmp += s[i];
            int a = stoi(tmp);
            flag = (a == root);
        } else if (s[0] == 'I') {    // full tree
            flag = is_full;
        } else {
            int a, b, i = 0;
            for (; isdigit(s[i]); ++i) tmp += s[i];
            a = stoi(tmp);
            tmp.clear();
            while (i < s.size() && !isdigit(s[i])) ++i;
            for (; i < s.size() && isdigit(s[i]); ++i) tmp += s[i];
            b = stoi(tmp);

            if (s[s.size() - 1] == 's') flag = (p[a] == p[b]);    // siblings
            else if (s[s.size() - 1] == 'l') flag = (depth[a] == depth[b]); // level
            else if (s.find("parent") < s.size()) flag = (p[b] == a);
            else if (s.find("right") < s.size()) flag = (r[b] == a);
            else flag = (l[b] == a);
        }

        if (flag) printf("Yes\n");
        else printf("No\n");
    }

    return 0;
}
