#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
		vector<int> res;
        unordered_map<int, bool> flag;
        unordered_map<int, int> idx;
        for (int i = 0; i < nums.size(); ++i) {
            flag[nums[i]] = true;
            idx[nums[i]] = i;
        }

        for (int i = 0; i < nums.size(); ++i) {
            if (flag[target - nums[i]] && idx[target - nums[i]] != i) {
                res.push_back(i);
                res.push_back(idx[target - nums[i]]);
                break;
            }
        }

        return res;
    }
};