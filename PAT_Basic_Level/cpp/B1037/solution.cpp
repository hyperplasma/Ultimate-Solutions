#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

struct Money {
    int galleon, sickle, knut;
} p, a;

int is_greater(Money a, Money b) {
    if (a.galleon != b.galleon) return a.galleon > b.galleon;
    if (a.sickle != b.sickle) return a.sickle > b.sickle;
    return a.knut > b.knut;
}

int main(void) {
    scanf("%d.%d.%d %d.%d.%d", &p.galleon, &p.sickle, &p.knut, &a.galleon, &a.sickle, &a.knut);

    if (is_greater(p, a)) {
        swap(p, a);
        printf("-");
    }

    Money res;
    if (a.knut < p.knut) {
        a.sickle--;
        res.knut = 29 + a.knut - p.knut;
    } else res.knut = a.knut - p.knut;

    if (a.sickle < p.sickle) {
        a.galleon--;
        res.sickle = 17 + a.sickle - p.sickle;
    } else res.sickle = a.sickle - p.sickle;

    res.galleon = a.galleon - p.galleon;
    cout << res.galleon << "." << res.sickle << "." << res.knut;

    return 0;
}
