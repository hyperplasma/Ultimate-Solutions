#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

bool is_prime(int n) {
	if (n <= 1) return false;
	for (int i = 2; i <= n / i; ++i)
		if (n % i == 0) return false;
	return true;
}

int main() {
	int n;
	scanf("%d", &n);

	if (is_prime(n) && is_prime(n - 6)) printf("Yes\n%d\n", n - 6);
	else if (is_prime(n) && is_prime(n + 6)) printf("Yes\n%d\n", n + 6);
	else {
		int m;
		for (m = n + 1;; m++)
			if (is_prime(m) && (is_prime(m - 6) || is_prime(m + 6)))
				break;
		printf("No\n%d\n", m);
	}

	return 0;
}
