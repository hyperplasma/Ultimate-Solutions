#include <iostream>

using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int> &nums) {
        int temp = 0;
        int n = nums.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                temp = nums[i];
                int j;
                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap)
                    nums[j] = nums[j - gap];
                nums[j] = temp;
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }
};