#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

char num[10][10] = {
        "ling", "yi", "er", "san", "si",
        "wu", "liu", "qi", "ba", "jiu"
};

int main() {
    char s[200];
    for (int Q = 0; Q < 11; ++Q) {
        scanf("%s", &s);
        if (isdigit(s[0])) {
            if (strlen(s) == 1) {
                printf("%s", s);
                continue;
            }

            int a, b, res = 0;
            char op;
            sscanf(s, "%d%c%d", &a, &op, &b);

            if (op == '+') res = a + b;
            else if (op == '-') res = a - b;
            else if (op == '*') res = a * b;
            else if (op == '/') res = a / b;
            else if (op == '%') res = a % b;
            else if (op == '^') res = pow(a, b);
            printf("%d", res);
        } else if (s[0] == 's' && s[1] == 'q') {
            int a;
            sscanf(s, "sqrt%d", &a);
            printf("%d", (int) sqrt(a * 1.0));
        } else {
            for (int i = 0; i < 10; ++i)
                if (s[0] == num[i][0] && s[1] == num[i][1] && s[2] == num[i][2]) {
                    printf("%d", i);
                    break;
                }
        }
    }

    return 0;
}