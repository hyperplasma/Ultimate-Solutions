#include <iostream>
#include <cstring>
#include <algorithm>
#include <map>

using namespace std;

const int MAXN = 10010, INF = 1e7 + 10;

string s;
map<string, int> words;

int main() {
    getline(cin, s);

    for (int i = 0; i < s.size(); ++i) {
        if (isalnum(s[i])) {
            string word;
            int j = i;
            while (j < s.size() && isalnum(s[j])) {
                if (isupper(s[j])) s[j] = tolower(s[j]);
                word += s[j];
                ++j;
            }
            words[word]++;
            i = j;
        }
    }

    string max_word;
    int cnt = 0;
    for (auto word: words)
        if (word.second > cnt) {
            max_word = word.first;
            cnt = word.second;
        }

    cout << max_word << " " << cnt << endl;
    return 0;
}
