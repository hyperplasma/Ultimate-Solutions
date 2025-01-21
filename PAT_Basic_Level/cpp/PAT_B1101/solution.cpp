#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string a;
int d;

int main() {
    cin >> a >> d;
    int len = a.size();

    string b = a.substr(len - d) + a.substr(0, len - d);
    printf("%.2f", 1.0 * stoi(b) / stoi(a));

    return 0;
}
