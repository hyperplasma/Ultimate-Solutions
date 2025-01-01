#include <iostream>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> st;
        string res;
        for (int i = 0; i < s.size();) {
            st.clear();
            string temp;
            int j = i;
            while (j < s.size()) {
                if (st.count(s[j])) break;
                st.insert(s[j]);
                temp.push_back(s[j]);
                j++;
            }
            if (temp.size() > res.size()) res = temp;
            i++;
        }
        
        return res.size();
    }
};