#include<iostream>
#include<cstring>
#include<algorithm>

using namespace std;

const int MAXN = 10010;

int n;
struct Paper {
    string id;
    int price, num;
    int sale;
} paper[MAXN];

bool cmp1(Paper a, Paper b) {
    return a.num > b.num;
}

bool cmp2(Paper a, Paper b) {
    return a.sale > b.sale;
}

int main() {
    scanf("%d", &n);
    string id;
    for (int i = 0; i < n; ++i) {
        int price, num;
        cin >> id >> price >> num;
        paper[i] = {id, price, num, price * num};
    }

    sort(paper, paper + n, cmp1);
    cout << paper[0].id << " " << paper[0].num << endl;

    sort(paper, paper + n, cmp2);
    cout << paper[0].id << " " << paper[0].sale << endl;

    return 0;
}
