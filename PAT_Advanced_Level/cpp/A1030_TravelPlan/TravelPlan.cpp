#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

const int N = 510;

int n, m, S, T;
int g[N][N], c[N][N];
int dist[N], cost[N], pre[N];
bool st[N];

void dijkstra() {
	memset(dist, 0x3f, sizeof(dist));
	memset(cost, 0x3f, sizeof(cost));
	dist[S] = 0;
	cost[S] = 0;
	pre[S] = S;

	for (int i = 0; i < n; ++i) {
		int t = -1;
		for (int j = 0; j < n; ++j)
			if (!st[j] && (t == -1 || dist[j] < dist[t])) t = j;
		st[t] = true;

		for (int j = 0; j < n; ++j) {
			if (dist[j] > dist[t] + g[t][j]) {
				dist[j] = dist[t] + g[t][j];
				cost[j] = cost[t] + c[t][j];
				pre[j] = t;
			} else if (dist[j] == dist[t] + g[t][j]) {
				if (cost[j] > cost[t] + c[t][j]) {
					cost[j] = cost[t] + c[t][j];
					pre[j] = t;
				}
			}
		}
	}
}

void print() {
	int stk[N], top = -1;
	int x = T;

	while (x != S) {
		stk[++top] = x;
		x = pre[x];
	}
	stk[++top] = S;

	while (top != -1) cout << stk[top--] << " ";
}

int main() {
	cin >> n >> m >> S >> T;
	memset(g, 0x3f, sizeof(g));
	memset(c, 0x3f, sizeof(c));

	for (int i = 0; i < m; ++i) {
		int a, b, L, W;
		cin >> a >> b >> L >> W;
		g[a][b] = g[b][a] = L;
		c[a][b] = c[b][a] = W;
	}

	dijkstra();

	print();
	cout << dist[T] << " " << cost[T] << endl;

	return 0;
}
