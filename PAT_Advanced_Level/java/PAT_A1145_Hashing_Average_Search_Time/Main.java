package PAT_A1145_Hashing_Average_Search_Time;

import java.io.*;

public class Main {
    static int mSize, n, m;
    static int[] hash;

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int getNextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    static boolean insert(int key, int tableSize) {
        for (int i = 0; i <= tableSize; i++) {
            int pos = (key + i * i) % tableSize;
            if (hash[pos] == 0) {
                hash[pos] = key;
                return true;
            }
        }
        return false;
    }

    static int search(int key, int tableSize) {
        for (int i = 0; i <= tableSize; i++) {
            int pos = (key + i * i) % tableSize;
            if (hash[pos] == 0) {
                return i + 1;
            }
            if (hash[pos] == key) {
                return i + 1;
            }
        }
        return tableSize + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        mSize = Integer.parseInt(inputs[0]);
        n = Integer.parseInt(inputs[1]);
        m = Integer.parseInt(inputs[2]);

        int tSize = getNextPrime(mSize);
        hash = new int[tSize];

        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(inputs[i]);
            if (!insert(num, tSize)) {
                System.out.println(num + " cannot be inserted.");
            }
        }

        inputs = br.readLine().split(" ");
        double totalCompares = 0;
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(inputs[i]);
            totalCompares += search(key, tSize);
        }

        System.out.printf("%.1f\n", totalCompares / m);
    }
}
