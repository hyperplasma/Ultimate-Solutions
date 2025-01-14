#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 10010, M = 1010;

int n, m;
struct Person {
    string card;
    int site;
    string date;
    int num;
    int score;
} p[N];
struct Site {
    int num;
    int total;
};
vector <Person> levels[3];    // ppl of level (0 = T  1 = A  2 = B)
vector <Person> sites[M];    // ppl in site

int main() {
    scanf("%d%d", &n, &m);

    string card, date;
    for (int i = 0; i < n; ++i) {
        int score, site, num;
        cin >> card;
        scanf("%d", &score);

        site = stoi(card.substr(1, 3));
        date = card.substr(4, 6);
        num = stoi(card.substr(10, 3));

        Person ppl = {card, site, date, num, score};
        p[i] = ppl;
        sites[site].push_back(ppl);
        if (card[0] == 'T') levels[0].push_back(ppl);
        else if (card[0] == 'A') levels[1].push_back(ppl);
        else levels[2].push_back(ppl);
    }

    for (int Q = 1; Q <= m; ++Q) {
        int type;
        scanf("%d", &type);

        if (type == 1) {
            char lchar;
            cin >> lchar;
            int lnum;
            if (lchar == 'T') lnum = 0;
            else if (lchar == 'A') lnum = 1;
            else lnum = 2;

            sort(levels[lnum].begin(), levels[lnum].end(), [](Person &a, Person &b) {
                if (a.score != b.score) return a.score > b.score;
                return a.card < b.card;
            });

            printf("Case %d: 1 %c\n", Q, lchar);
            if (levels[lnum].empty()) printf("NA\n");
            else {
                for (auto it: levels[lnum])
                    printf("%s %d\n", it.card.c_str(), it.score);
            }
        } else if (type == 2) {
            int site;
            scanf("%d", &site);

            int sum = 0;
            for (auto it: sites[site])
                sum += it.score;

            printf("Case %d: 2 %d\n", Q, site);
            if (sites[site].empty()) printf("NA\n");
            else printf("%d %d\n", sites[site].size(), sum);
        } else {
            string date;
            cin >> date;

            vector <Site> v;
            for (int i = 101; i < M; ++i) {
                int cnt = 0;
                for (auto it: sites[i])
                    if (it.date == date) cnt++;

                if (cnt > 0) v.push_back({i, cnt});
            }

            sort(v.begin(), v.end(), [](Site &a, Site &b) {
                if (a.total != b.total) return a.total > b.total;
                return a.num < b.num;
            });

            printf("Case %d: 3 %s\n", Q, date.c_str());
            if (v.empty()) printf("NA\n");
            else {
                for (auto it: v)
                    printf("%d %d\n", it.num, it.total);
            }
        }
    }

    return 0;
}
