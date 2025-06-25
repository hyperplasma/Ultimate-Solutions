#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAXN = 10010, INF = 1e7 + 10;

int n;
int boy_num = 0, girl_num = 0;
string first_girl, last_boy;
string first_g_id, last_b_id;
int first_g_score = -INF, last_b_score = INF;

int main() {
    cin >> n;

    string name, gender, id;
    int score;
    for (int i = 0; i < n; ++i) {
        cin >> name >> gender >> id >> score;

        if (gender == "M") {
            boy_num++;
            if (score < last_b_score) {
                last_boy = name;
                last_b_id = id;
                last_b_score = score;
            }
        } else {
            girl_num++;
            if (score > first_g_score) {
                first_girl = name;
                first_g_id = id;
                first_g_score = score;
            }
        }
    }

    if (girl_num == 0) printf("Absent\n");
    else cout << first_girl << " " << first_g_id << endl;

    if (boy_num == 0) printf("Absent\n");
    else cout << last_boy << " " << last_b_id << endl;

    if (girl_num == 0 || boy_num == 0) printf("NA\n");
    else printf("%d", first_g_score - last_b_score);

    return 0;
}
