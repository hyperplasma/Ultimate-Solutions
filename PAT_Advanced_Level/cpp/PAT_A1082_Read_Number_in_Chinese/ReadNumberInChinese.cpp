#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

string num1[10] = {
        "ling", "yi", "er", "san", "si",
        "wu", "liu", "qi", "ba", "jiu",
};
string num2[4] = {"", "Shi", "Bai", "Qian"};
string num3[3] = {"", "Wan", "Yi"};

bool check_ling(string s) {
    return s.size() >= 5 && s.substr(s.size() - 5) == "ling ";
}

string convert(int n) {
    vector<int> nums;
    while (n) {
        nums.push_back(n % 10);
        n /= 10;
    }

    string res;
    for (int i = nums.size() - 1; i >= 0; --i) {
        int t = nums[i];
        if (t != 0) res += num1[t] + " ";
        else if (!check_ling(res)) res += "ling ";
        if (t != 0 && i) res += num2[i] + " ";
    }

    while (check_ling(res)) res = res.substr(0, res.size() - 5);
    return res;
}

int main() {
    int n;
    cin >> n;
    if (n == 0) cout << "ling";
    else {
        if (n < 0) {
            cout << "Fu ";
            n = -n;
        }

        vector<int> nums;
        while (n) {
            nums.push_back(n % 10000);
            n /= 10000;
        }

        string res;
        for (int i = nums.size() - 1; i >= 0; --i) {
            int t = nums[i];
            if (res.size() && t < 1000 &&
                !(res.size() >= 5 && res.substr(res.size() - 5) == "ling "))
                res += "ling ";
            if (t != 0) res += convert(t);
            if (t != 0 && i) res += num3[i] + " ";
        }

        while (check_ling(res)) res = res.substr(0, res.size() - 5);
        res.pop_back();
        cout << res;
    }
    return 0;
}
