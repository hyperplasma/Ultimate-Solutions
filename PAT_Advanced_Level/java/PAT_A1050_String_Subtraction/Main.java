package PAT_A1050_String_Subtraction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        Set<Character> st = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            st.add(s2.charAt(i));
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (!st.contains(s1.charAt(i))) {
                res.append(s1.charAt(i));
            }
        }

        System.out.println(res);
    }
}