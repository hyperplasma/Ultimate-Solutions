#include <iostream>
#include <string>

using namespace std;

void checkMultiTwo(const string &N) {
    // 检查N的位数是否为奇数
    if (N.size() & 1) {
        cout << "Error: " << N.size() << " digit(s)" << endl;
        return;
    }

    const string a = N.substr(0, N.size() / 2);
    const string b = N.substr(N.size() / 2);

    // 判断是否多二了一点
    const int n_mod10 = b.back() - '0';
    const int m_mod10 = a.back() - '0';
    bool flag = true;
    for (int i = 0; i < a.size() - 1; ++i) {
        if (a[i] != b[i]) {
            flag = false;
            break;
        }
    }

    if (n_mod10 - m_mod10 == 2 && flag) {
        cout << "Yes: " << b << " - " << a << " = 2" << endl;
    } else {
        cout << "No: " << b << " - " << a << " != 2" << endl;
    }
}

int main() {
    string N;
    cin >> N;

    checkMultiTwo(N);

    return 0;
}
