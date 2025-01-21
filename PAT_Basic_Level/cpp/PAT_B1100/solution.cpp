#include <iostream>
#include <cstring>
#include <unordered_set>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
struct Person {
    string id, date;
};
unordered_set <string> st;
vector <Person> v, v0;

bool cmp(Person a, Person b) {
    return a.date < b.date;
}

int main() {
    scanf("%d", &n);
    string id;
    for (int i = 0; i < n; ++i) {
        cin >> id;
        st.insert(id);
    }

    scanf("%d", &m);
    for (int i = 0; i < m; ++i) {
        cin >> id;
        string date = id.substr(6, 8);
        Person a = {id, date};

        if (st.count(id)) v.push_back(a);
        v0.push_back(a);
    }

    if (!v.empty()) {
        sort(v.begin(), v.end(), cmp);
        printf("%d\n%s", (int) v.size(), v[0].id.c_str());
    } else {
        sort(v0.begin(), v0.end(), cmp);
        printf("0\n%s", v0[0].id.c_str());
    }

    return 0;
}
