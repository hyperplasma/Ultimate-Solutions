#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_set>

using namespace std;

const int INF = 0x3f3f3f3f;

int n, m;
unordered_set <string> st;

int main() {
    cin >> n;
    while (n--) {
        string id;
        cin >> id;
        st.insert(id);
    }

    cin >> m;
    string old_alu, old_gst;
    int old_alu_date = INF, old_gst_date = INF, cnt = 0;
    while (m--) {
        string id;
        cin >> id;
        int date = stoi(id.substr(6, 8));

        if (st.count(id)) {
            cnt++;
            if (date < old_alu_date) {
                old_alu_date = date;
                old_alu = id;
            }
        } else {
            if (date < old_gst_date) {
                old_gst_date = date;
                old_gst = id;
            }
        }
    }

    cout << cnt << endl;
    if (cnt == 0) cout << old_gst << endl;
    else cout << old_alu << endl;

    return 0;
}
