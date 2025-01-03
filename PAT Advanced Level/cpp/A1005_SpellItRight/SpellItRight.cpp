#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

char words[][8] = {
        "zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine",
};

int main() {
    string n;
    int sum = 0;
    cin >> n;

    for (int i = 0; i < n.size(); ++i) sum += n[i] - '0';

    string s = to_string(sum);
    for (int i = 0; i < s.size(); ++i) {
        if (i > 0) cout << " ";
        cout << words[s[i] - '0'];
    }

    return 0;
}
