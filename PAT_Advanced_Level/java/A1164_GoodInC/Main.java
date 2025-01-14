package A1164_GoodInC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试点3超时
 */
public class Main {
    static char[][][] letters = new char[26][7][5];
    static boolean isFirstWord = true;

    static void printWord(String word) {
        if (word.isEmpty()) return;

        if (isFirstWord) {
            isFirstWord = false;
        } else {
            System.out.println();
        }

        char[][] result = new char[7][60];
        int width = 0;

        for (int k = 0; k < word.length(); k++) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 5; j++) {
                    int letterIndex = word.charAt(k) - 'A';
                    result[i][k * 6 + j] = letters[letterIndex][i][j];
                    width = k * 6 + j;
                }
            }
        }

        for (int k = 1; k < word.length(); k++) {
            for (int i = 0; i < 7; i++) {
                result[i][k * 6 - 1] = ' ';
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= width; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int a = 0; a < 26; a++) {
            for (int i = 0; i < 7; i++) {
                String line = br.readLine();
                for (int j = 0; j < 5; j++) {
                    letters[a][i][j] = line.charAt(j);
                }
            }
        }

        StringBuilder curWord = new StringBuilder();
        int c;
        while ((c = br.read()) != -1) {
            char ch = (char) c;
            if (Character.isUpperCase(ch)) {
                curWord.append(ch);
            } else {
                printWord(curWord.toString());
                curWord.setLength(0);
            }
        }

        printWord(curWord.toString());
    }
}