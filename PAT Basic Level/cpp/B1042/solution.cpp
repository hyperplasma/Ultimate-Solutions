#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int cnt[260];

int main() {
    char s[1010];
    fgets(s, sizeof(s), stdin);

    int len = strlen(s);
    for (int i = 0; i < len; ++i) {
        if (isalpha(s[i])) {
            if (isupper(s[i])) s[i] = s[i] - 'A' + 'a';
            cnt[s[i]]++;
        }
    }

    char max_c;
    int max_cnt = -1;
    for (int i = 'a'; i <= 'z'; ++i)
        if (cnt[i] > max_cnt) {
            max_c = i;
            max_cnt = cnt[i];
        }

    printf("%c %d", max_c, max_cnt);

    return 0;
}