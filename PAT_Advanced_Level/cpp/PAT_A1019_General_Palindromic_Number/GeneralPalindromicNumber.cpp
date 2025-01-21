#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

int n, b;
vector<int> nums;

bool check() {
    for (int i = 0, j = nums.size() - 1; i < j; i++, j--)
        if (nums[i] != nums[j]) return false;
    return true;
}

int main() {
    cin >> n >> b;

    if (!n) nums.push_back(0);
    while (n) {
        nums.push_back(n % b);
        n /= b;
    }

    if (check()) puts("Yes");
    else puts("No");

    cout << nums.back();
    for (int i = nums.size() - 2; i >= 0; i--) cout << ' ' << nums[i];

    return 0;
}
