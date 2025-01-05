package A1071_SpeechPatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试点2、3超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                StringBuilder word = new StringBuilder();
                int j = i;
                while (j < s.length() && Character.isLetterOrDigit(s.charAt(j))) {
                    char ch = s.charAt(j);
                    if (Character.isUpperCase(ch)) {
                        ch = Character.toLowerCase(ch);
                    }
                    word.append(ch);
                    ++j;
                }
                String wordStr = word.toString();
                words.put(wordStr, words.getOrDefault(wordStr, 0) + 1);
                i = j;
            }
        }

        String maxWord = "";
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() > cnt) {
                maxWord = entry.getKey();
                cnt = entry.getValue();
            }
        }

        System.out.println(maxWord + " " + cnt);
    }
}