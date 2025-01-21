#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

string words[5] = {"W ", "T ", "L "};

int main() {
    double res = 1.0;
    for (int i = 0; i < 3; ++i) {
        double x, max_x = 0;
        int idx = 0;
        for (int j = 0; j < 3; ++j) {
            scanf("%lf", &x);
            if (x > max_x) {
                max_x = x;
                idx = j;
            }
        }
        res *= max_x;
        cout << words[idx];
    }

    printf("%.2f\n", (res * 0.65 - 1) * 2);

    return 0;
}
