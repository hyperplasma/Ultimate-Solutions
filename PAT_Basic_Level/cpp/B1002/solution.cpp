#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string words[] = {
        "ling", "yi", "er", "san", "si",
        "wu", "liu", "qi", "ba", "jiu",
};

string s;
int sum;

int main() {
    cin >> s;
    for (int i = 0; i < s.size(); i++) sum += s[i] - '0';

    string res = to_string(sum);
    for (int i = 0; i < res.size(); i++) {
        if (i > 0) cout << " ";
        cout << words[res[i] - '0'];
    }

    return 0;
}
