#include <iostream>

using namespace std;

const int INF = 0x3f3f3f3f;

class Solution {
public:
    int maxSubArray(vector<int> &nums) {
        int n = nums.size();
        int thisSum = 0, maxSum = -INF;
        for (int i = 0; i < n; i++) {
            thisSum += nums[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }
};