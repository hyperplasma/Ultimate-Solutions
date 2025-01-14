#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 120;

char g[27][8][6];
bool is_first = true;

void print(string word) {
    if (word.empty()) return;

    if (is_first) is_first = false;
    else cout << endl;

    char res[7][60] = {0};
    int width = 0;
    for (int k = 0; k < word.size(); ++k)
        for (int i = 0; i < 7; ++i)
            for (int j = 0; j < 5; ++j) {
                int a = word[k] - 'A';
                res[i][k * 6 + j] = g[a][i][j];
                width = k * 6 + j;
            }

    for (int k = 1; k < word.size(); ++k)
        for (int i = 0; i < 7; ++i)
            res[i][k * 6 - 1] = ' ';

    for (int i = 0; i < 7; ++i) {
        for (int j = 0; j <= width; ++j)
            cout << res[i][j];
        cout << endl;
    }
}

int main() {
    for (int a = 0; a < 26; ++a)
        for (int i = 0; i < 7; ++i)
            for (int j = 0; j < 5; ++j)
                cin >> g[a][i][j];

    string word;
    char c;
    while ((c = getchar()) != -1) {
        if (isupper(c)) word += c;
        else {
            print(word);
            word.clear();
        }
    }

    print(word);

    return 0;
}
