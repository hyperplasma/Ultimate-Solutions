#include <iostream>
#include <cstring>
#include <algorithm>
#include <set>
#include <stack>

using namespace std;

int n;
stack<int> s;
multiset<int> l, r;        // 左小右大，mid = l.LastElem, l.size > r.size

void adjust() {
    while (r.size() > l.size()) {
        l.insert(*r.begin());
        r.erase(r.begin());
    }

    while (l.size() > r.size() + 1) {
        auto it = l.end();
        it--;
        r.insert(*it);
        l.erase(it);
    }
}

int main() {
    scanf("%d", &n);

    string op;
    while (n--) {
        cin >> op;

        if (op == "Push") {
            int x;
            scanf("%d", &x);
            s.push(x);

            if (r.empty() || x < *r.begin()) l.insert(x);
            else r.insert(x);

            adjust();
        } else if (op == "Pop") {
            if (s.empty()) printf("Invalid\n");
            else {
                int x = s.top();
                s.pop();
                printf("%d\n", x);

                auto it = l.end();
                it--;
                if (x <= *it) l.erase(l.find(x));
                else r.erase(r.find(x));

                adjust();
            }
        } else {
            if (s.empty()) printf("Invalid\n");
            else {
                auto it = l.end();
                it--;
                printf("%d\n", *it);
            }
        }
    }

    return 0;
};
