#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int m;
string open_id, open_time;
string close_id, close_time;

int main() {
    cin >> m;

    for (int i = 0; i < m; i++) {
        string id, in_time, out_time;
        cin >> id >> in_time >> out_time;

        if (!i || in_time < open_time) {    // 更新开门的人
            open_id = id;
            open_time = in_time;
        }

        if (!i || out_time > close_time) {    // 更新锁门的人
            close_id = id;
            close_time = out_time;
        }
    }

    cout << open_id << ' ' << close_id << endl;

    return 0;
}
