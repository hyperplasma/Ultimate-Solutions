#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int countCharacters(vector <string> &words, string chars) {
        int res = 0;
        unordered_map<char, int> cnt;

        for (int i = 0; i < chars.size(); ++i) cnt[chars[i]]++;

        for (int i = 0; i < words.size(); ++i) {
            unordered_map<char, int> temp_cnt = cnt;
            bool success = true;
            for (int j = 0; j < words[i].size(); ++j) {
                if (!temp_cnt[words[i][j]]) {
                    success = false;
                    break;
                }
                temp_cnt[words[i][j]]--;
            }
            if (success) res += words[i].size();
        }

        return res;
    }
};