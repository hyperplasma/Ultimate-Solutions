#include <iostream>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <vector>

using namespace std;

int n;
char head[10];

struct Node {
    string address;
    int key;
    string next;

    bool operator<(const Node &t) const {
        return key < t.key;
    }
};

unordered_map <string, Node> map;

int main() {
    scanf("%d%s", &n, head);

    char address[10], next[10];
    while (n--) {
        int key;
        scanf("%s%d%s", address, &key, next);
        map[address] = {address, key, next};
    }

    vector <Node> nodes;
    for (string i = head; i != "-1"; i = map[i].next) nodes.push_back(map[i]);

    printf("%d ", nodes.size());
    if (nodes.empty()) puts("-1");
    else {
        sort(nodes.begin(), nodes.end());
        printf("%s\n", nodes[0].address.c_str());
        for (int i = 0; i < nodes.size(); i++) {
            if (i + 1 == nodes.size())
                printf("%s %d -1\n", nodes[i].address.c_str(), nodes[i].key);
            else
                printf("%s %d %s\n", nodes[i].address.c_str(), nodes[i].key, nodes[i + 1].address.c_str());
        }
    }

    return 0;
}
