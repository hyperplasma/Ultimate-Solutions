#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>

using namespace std;

int n;
int win_cnt, tie_cnt, lose_cnt;
int a_win[3], b_win[3];
unordered_map<char, int> mp = {{'C', 0},
                               {'J', 1},
                               {'B', 2}};
unordered_map<int, char> mp_r = {{0, 'C'},
                                 {1, 'J'},
                                 {2, 'B'}};

bool cmp(char a, char b) {
    return a < b;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        char a, b;
        scanf(" %c %c", &a, &b);
        if ((a == 'C' && b == 'J') || (a == 'J' && b == 'B') || (a == 'B' && b == 'C')) {
            win_cnt++;
            a_win[mp[a]]++;
        } else if ((b == 'C' && a == 'J') || (b == 'J' && a == 'B') || (b == 'B' && a == 'C')) {
            lose_cnt++;
            b_win[mp[b]]++;
        } else {
            tie_cnt++;
        }
    }

    int a_max = *max_element(a_win, a_win + 3), b_max = *max_element(b_win, b_win + 3);

    vector<char> res_a, res_b;
    for (int i = 0; i < 3; i++)
        if (a_win[i] == a_max)
            res_a.push_back(mp_r[i]);
    for (int i = 0; i < 3; i++)
        if (b_win[i] == b_max)
            res_b.push_back(mp_r[i]);

    sort(res_a.begin(), res_a.end(), cmp);
    sort(res_b.begin(), res_b.end(), cmp);
    printf("%d %d %d\n", win_cnt, tie_cnt, lose_cnt);
    printf("%d %d %d\n", lose_cnt, tie_cnt, win_cnt);
    printf("%c %c", res_a[0], res_b[0]);

    return 0;
}
